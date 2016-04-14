package main

import (
	"crypto/md5"
	"fmt"
)

func get_least_num(key string, start int, end int) int {
	zeroes := "000000"
	len_zeroes := len(zeroes)
	for i := start; i < end; i++ {
		data := []byte(fmt.Sprintf("%s%d", key, i))
		h := md5.Sum(data)
		if fmt.Sprintf("%x", h)[0:len_zeroes] == zeroes {
			return i
		}
	}
	return 0
}

func main() {
	fmt.Printf("%d\n", get_least_num("yzbqklnj", 1, 10000000))
}
