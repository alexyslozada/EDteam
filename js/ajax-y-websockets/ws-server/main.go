package main

import (
	"encoding/json"
	"net/http"

	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	"github.com/labstack/gommon/log"
	"github.com/olahol/melody"
)

var mel *melody.Melody
var usuarios map[string]string

const token = "8e47f8c9-858e-4c9b-8bc6-9b2aa4bff448"

type ResponseWebSocket struct {
	Tipo         string `json:"type"`
	DataResponse `json:"data_response"`
}

type DataResponse struct {
	Name    string `json:"name"`
	Message string `json:"message"`
}

type ResponseSale struct {
	Tipo     string `json:"type"`
	DataSale `json:"data_sale"`
}

type DataSale struct {
	Product  float64 `json:"product"`
	Quantity float64 `json:"quantity"`
}

func init() {
	mel = melody.New()
	mel.Upgrader.CheckOrigin = func(r *http.Request) bool {
		// aqui se puede hacer la validación del dominio del navegador
		return true
	}
	mel.Upgrader.ReadBufferSize = 4096
	mel.Upgrader.WriteBufferSize = 4096
	mel.Config.MaxMessageSize = 4096
	mel.Config.MessageBufferSize = 4096
	usuarios = make(map[string]string)
}

func main() {
	e := echo.New()
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: []string{"*"},
		AllowMethods: []string{echo.GET},
	}))

	e.Static("/", "public")
	e.POST("/login", login)
	e.GET("/ws", websocket)

	err := e.Start(":9999")
	if err != nil {
		log.Fatal("error en el servidor: %v", err)
	}
}

type UserRequest struct {
	Name     string `json:"name"`
	Password string `json:"password"`
}

func login(c echo.Context) error {
	u := &UserRequest{}
	validUsers := loadUsers()

	err := c.Bind(u)
	if err != nil {
		log.Printf("estructura usuario no válida: %v", err)
	}

	log.Print(u)
	isAuthorized := false
	for _, v := range validUsers {
		if u.Name == v.Name && u.Password == v.Password {
			isAuthorized = true
			break
		}
	}

	response := make(map[string]string)
	if !isAuthorized {
		response["message"] = "usuario o contraseña no validos"
		return c.JSON(http.StatusUnauthorized, response)
	}

	response["message"] = "ok"
	response["token"] = token
	return c.JSON(http.StatusOK, response)
}

func loadUsers() []UserRequest {
	urs := make([]UserRequest, 0)

	urs = append(urs, UserRequest{"pedro", "123"}, UserRequest{"pablo", "321"}, UserRequest{"juan", "654"})
	return urs
}

func websocket(c echo.Context) error {
	if c.QueryParam("token") == token {
		mel.HandleRequest(c.Response().Writer, c.Request())
		mel.HandleConnect(conectarse)
		mel.HandleDisconnect(desconectarse)
		mel.HandleMessage(mensaje)
		return nil
	}

	response := make(map[string]string)
	response["message"] = "no estás autorizado para ingresar al WS"
	return c.JSON(http.StatusForbidden, response)
}

func conectarse(s *melody.Session) {
	uName := getUserFromQuery(s)
	usuarios[uName] = uName
}

func getUserFromQuery(s *melody.Session) string {
	uName := s.Request.URL.Query().Get("uname")
	return uName
}

func desconectarse(s *melody.Session) {
	uName := getUserFromQuery(s)
	delete(usuarios, uName)
}

func mensaje(s *melody.Session, msg []byte) {
	var data map[string]interface{}

	err := json.Unmarshal(msg, &data)
	if err != nil {
		log.Printf("no se pudo convertir el json recibido: %v", err)
		return
	}

	tipo, ok := data["type"]
	if !ok {
		log.Printf("el mensaje recibido no tiene tipo")
	}

	switch tipo {
	case "message":
		uName := getUserFromQuery(s)
		msg := data["message"]

		dr := DataResponse{
			Name:    uName,
			Message: msg.(string),
		}
		rws := ResponseWebSocket{
			Tipo:         "message",
			DataResponse: dr,
		}

		r, err := json.Marshal(rws)
		if err != nil {
			log.Printf("no se pudo procesar el objeto de respuesta: %v", err)
		}

		mel.Broadcast(r)
	case "sale":
		product := data["product"]
		quantity := data["quantity"]
		dr := DataSale{
			Product:  product.(float64),
			Quantity: quantity.(float64),
		}
		rws := ResponseSale{
			Tipo:     "sale",
			DataSale: dr,
		}
		r, err := json.Marshal(rws)
		if err != nil {
			log.Printf("no se pudo procesar el objeto de respuesta: %v", err)
		}

		mel.Broadcast(r)
	case "ping":
		mel.BroadcastFilter([]byte(`{"type": "pong"}`),
			func(sa *melody.Session) bool {
				return sa == s
			},
		)
	default:
		log.Printf("tipo no es procesable")
	}
}
