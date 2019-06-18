package main

import (
	"net/http"
	"time"

	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	"github.com/labstack/gommon/log"
)

func main() {
	e := echo.New()
	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// CORS restricted
	// wth GET, PUT, POST or DELETE method.
	e.Use(middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: []string{"*"},
		AllowMethods: []string{echo.GET, echo.PUT, echo.POST, echo.DELETE},
	}))

	e.Static("/", "public")
	e.GET("/json", getJSON)

	log.Error(e.Start(":9000"))
}

// Devuelve información tipo JSON
func getJSON(c echo.Context) error {
	time.Sleep(2 * time.Second)
	ns := make([]Noticia, 0)
	ns = append(ns, Noticia{Titulo: "Nuevo curso JS", Contenido: "Aprende el lenguaje de programación de la WEB", Fecha: time.Now()})
	ns = append(ns, Noticia{Titulo: "Nuevo Sorteo de cursos", Contenido: "Noticias fake por todo internet", Fecha: time.Now()})
	ns = append(ns, Noticia{Titulo: "La comunidad está onfaiel", Contenido: "Todos comentando sobre las nuevas funcionalidades", Fecha: time.Now()})
	return c.JSON(http.StatusOK, ns)
}

type Noticia struct {
	Titulo    string
	Contenido string
	Fecha     time.Time
}
