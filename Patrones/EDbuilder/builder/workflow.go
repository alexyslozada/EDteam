package builder

import "fmt"

type WorkFlow struct {
	Actions []int
}

func (w *WorkFlow) GetElements() {
	fmt.Println("Estoy obteniendo los elementos necesarios")
}

func (w *WorkFlow) Process() {
	fmt.Println("Estoy procesando todos los elementos enviados")
}

func (w *WorkFlow) End() {
	fmt.Println("Termino el gran proceso, fue duro pero lo logramos.")
}

func (w *WorkFlow) LoadActions(actions []int) {
	w.Actions = actions
}

func (w *WorkFlow) Work() {
	for _, v := range w.Actions {
		switch v {
		case 1:
			w.GetElements()
		case 2:
			w.Process()
		case 3:
			w.End()
		default:
			fmt.Println("No conozco esa acción, lo lamento :(")
		}
	}
}
