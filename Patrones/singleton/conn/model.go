package conn

import (
	"sync"
)

var (
	once     sync.Once
	instance *connect
)

func init() {
	once.Do(func() {
		instance = createConn()
	})
}

type connect struct {
	name  string
	count int
}

func createConn() *connect {
	return &connect{"Mi conexión", 0}
}

// GetInstance devuelve una instancia de la conexión
func GetInstance() *connect {
	return instance
}

// Increment aumenta el contador
func (i *connect) Increment() {
	i.count++
}

// Decrement disminuye el contador
func (i *connect) Decrement() {
	if i.count > 0 {
		i.count--
	}
}

func (i *connect) GetName() string {
	return i.name
}

func (i *connect) SetName(n string) {
	i.name = n
}

func (i *connect) GetCount() int {
	return i.count
}
