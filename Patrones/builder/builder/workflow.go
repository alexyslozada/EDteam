package builder

import "fmt"

type WorkFlow struct {
	Actions []int
}

func (wf *WorkFlow) GetRequeriments() {
	fmt.Println("Aqui obtengo los requerimientos")
}

func (wf *WorkFlow) Process() {
	fmt.Println("Aqui proceso los requerimientos")
}

func (wf *WorkFlow) End() {
	fmt.Println("Terminé")
}

func (wf *WorkFlow) Work() {
	for _, v := range wf.Actions {
		switch v {
		case 1:
			wf.GetRequeriments()
		case 2:
			wf.Process()
		case 3:
			wf.End()
		default:
			fmt.Println("Acción desconocida")
		}
	}
}

func (wf *WorkFlow) LoadActions(actions []int) {
	wf.Actions = actions
}
