package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
)

func main() {
	var message string
	fmt.Print("Bash keyboard to generate entropy for dice roll: ")
	fmt.Scanln(&message)
	fmt.Println("Lots of entropy generated…")
	fmt.Printf("You rolled: %d\n", rand.Intn(6))

	fmt.Println("Everything you now type will be spewed back! ^D (Ctrl-D) to exit")
	s := bufio.NewScanner(os.Stdin)
	for s.Scan() {
		fmt.Printf("> %s\n", s.Text())
	}
}
