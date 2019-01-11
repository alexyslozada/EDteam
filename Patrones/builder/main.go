package main

import (
	"encoding/json"
	"io/ioutil"
	"log"

	"./builder"
)

type Process struct {
	Robot   int   `json:"robot"`
	Actions []int `json:"actions"`
}

var p Process

func main() {
	loadProcess()

	b := builder.Builder{}
	b.SetRobot(p.Robot)

	for _, v := range p.Actions {
		b.AddAction(v)
	}

	b.SetActions()
	b.Exec.Work()
}

func loadProcess() {
	f, err := ioutil.ReadFile("procesos.json")
	if err != nil {
		log.Fatal("No se pudo leer el archivo")
	}

	err = json.Unmarshal(f, &p)
	if err != nil {
		log.Fatal("No se pudo convertir el json")
	}
}
