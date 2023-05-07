package main

import (
	"fmt"
	"time"
)

func main() {
	num := 3
	chans := make([]chan int, 0)
	for i := 0; i < num; i++ {
		chans = append(chans, make(chan int, 1))
	}

	for i := 0; i < num; i++ {
		go func(index int) {
			for {
				j := <-chans[index]
				fmt.Print(j + 1)
				chans[(index+1)%num] <- (j + 1) % num
			}
		}(i)
	}

	chans[0] <- 0

	time.Sleep(10000)
}
