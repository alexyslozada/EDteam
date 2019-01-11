package builder

type Builder struct {
	Exec    Executer
	Actions []int
}

func (b *Builder) SetExecuter(i int) {
	switch i {
	case 1:
		b.Exec = new(WorkFlow)
	case 2:
		b.Exec = new(Vehicle)
	}
}

func (b *Builder) AddAction(i int) {
	// En javascript sería algo como:
	// b.Actions.push(i)
	b.Actions = append(b.Actions, i)
}

func (b *Builder) SetActions() {
	b.Exec.LoadActions(b.Actions)
}
