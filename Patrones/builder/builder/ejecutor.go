package builder

type Ejecutor interface {
	Work()
	LoadActions(actions []int)
}
