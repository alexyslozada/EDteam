package main

import (
	"fmt"

	"./conn"
)

func main() {
	instance := conn.GetInstance()
	fmt.Println(instance)
	instance.Increment()
	fmt.Println("instance:", instance)
	other := conn.GetInstance()
	fmt.Println("other:", other)
	other.Increment()
	other.SetName("nuevo nombre")
	fmt.Println("instance:", instance, instance.GetName())
	fmt.Println("other:", other, other.GetName())
}
