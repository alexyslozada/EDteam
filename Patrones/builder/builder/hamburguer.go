package builder

import "fmt"

type Hamburger struct {
	Actions []int
}

func (h *Hamburger) GetMeat() {
	fmt.Println("Preparando la carne")
}

func (h *Hamburger) CookMeat() {
	fmt.Println("Cocinando la carne")
}

func (h *Hamburger) GetBread() {
	fmt.Println("Preparando el pan")
}

func (h *Hamburger) SetHamburger() {
	fmt.Println("Emplatando la hamburguesa")
}

func (h *Hamburger) Work() {
	for _, v := range h.Actions {
		switch v {
		case 1:
			h.GetMeat()
		case 2:
			h.GetBread()
		case 3:
			h.SetHamburger()
		case 4:
			h.CookMeat()
		default:
			fmt.Println("Acción desconocida")
		}
	}
}

func (h *Hamburger) LoadActions(actions []int) {
	h.Actions = actions
}
