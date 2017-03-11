package main

import (
	"fmt"
)

func getNum() float64 {
	return 'π' * 3
}

func main() {
	fmt.Printf("0x%x\n", 'A')
	fmt.Printf("%f\n", getNum())

	// the code point value is used ('&' is in ASCII range => 0x0 to 0x7f)
	r := '&' * 2
	fmt.Printf("%T\n", r)
	fmt.Printf("%c\n", r)
	fmt.Printf("%d\n", r)

	// unicode => 0x0 to 0x10ffff
	res := '∫' * 2
	fmt.Printf("%T\n", res)
	// interesting!
	fmt.Printf("%c\n", res)
	fmt.Printf("%d\n", res)
	// unicode uses 1 byte for ASCII and up to 4 bytes for the rest
}
