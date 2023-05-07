package main

import "fmt"

var visited []int

func findCircleNum(isConnected [][]int) int {
	visited = make([]int, len(isConnected))
	provices := map[int]int{}
	res := 0
	for index := range isConnected {
		provices[index] = 1
	}
	for len(provices) > 0 {
		for key := range provices {
			dfs(provices, isConnected, key)
			break
		}
		//fmt.Printf("一次dfs %d \n", len(provices))
		res++
	}
	return res
}

func dfs(provices map[int]int, isConnected [][]int, pos int) {
	visited[pos] = 1
	delete(provices, pos)
	for key := range provices {
		_, ok := provices[key]
		if isConnected[pos][key] == 1 && ok && visited[key] == 0 {
			//fmt.Printf("传之前%d \n", len(provices))
			dfs(provices, isConnected, key)
			//fmt.Printf("传之后%d \n", len(provices))
		}
	}
}
