package builder

type Builder struct {
	Exec    Ejecutor
	Actions []int
}

func (b *Builder) SetRobot(i int) {
	switch i {
	case 1:
		b.Exec = new(WorkFlow)
	case 2:
		b.Exec = new(Hamburger)
	}
}

func (b *Builder) AddAction(i int) {
	b.Actions = append(b.Actions, i)
}

func (b *Builder) SetActions() {
	b.Exec.LoadActions(b.Actions)
}
