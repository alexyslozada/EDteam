package main

import (
	"encoding/json"
	"io/ioutil"
	"log"

	"./builder"
)

type Process struct {
	Executer int   `json:"executer"`
	Process  []int `json:"process"`
}

var p Process

func main() {
	loadProcess()

	b := builder.Builder{}
	b.SetExecuter(p.Executer)

	for _, v := range p.Process {
		b.AddAction(v)
	}

	b.SetActions()
	b.Exec.Work()
}

func loadProcess() {
	f, err := ioutil.ReadFile("process.json")
	if err != nil {
		log.Fatalf("no se pudo leer el archivo: %v", err)
	}

	err = json.Unmarshal(f, &p)
	if err != nil {
		log.Fatalf("no se pudo convertir el json al objeto: %v", err)
	}
}
