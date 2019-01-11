package builder

import "fmt"

type Vehicle struct {
	Actions []int
}

func (v *Vehicle) CompraMateriaPrima() {
	fmt.Println("Compro la materia prima")
}

func (v *Vehicle) Ensamblado() {
	fmt.Println("Ensamblo el vehículo")
}

func (v *Vehicle) Pintura() {
	fmt.Println("Pintamos el vehículo")
}

func (v *Vehicle) Pruebas() {
	fmt.Println("Estoy haciendo pruebas del vehículo")
}

func (v *Vehicle) LoadActions(actions []int) {
	v.Actions = actions
}

func (v *Vehicle) Work() {
	for _, x := range v.Actions {
		switch x {
		case 1:
			v.CompraMateriaPrima()
		case 2:
			v.Ensamblado()
		case 3:
			v.Pintura()
		case 4:
			v.Pruebas()
		default:
			fmt.Println("No conozco esa acción, lo lamento :(")
		}
	}
}
