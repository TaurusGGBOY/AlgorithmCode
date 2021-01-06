package main

import "fmt"

var visited [26][26]int


func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	alphabet := map[string]int{}
	matrix:=make([][26]float64,26)
	count := 0
	for index := range equations {
		_,ok1:=alphabet[equations[index][0]]
		if !ok1{
			alphabet[equations[index][0]]=count
			count++
		}
		_,ok2:=alphabet[equations[index][1]]
		if !ok2{
			alphabet[equations[index][1]]=count
			count++
		}
		matrix[alphabet[equations[index][0]]][alphabet[equations[index][1]]] = values[index]
		matrix[alphabet[equations[index][1]]][alphabet[equations[index][0]]] = 1/values[index]
	}
	var res []float64
	//print(matrix)
	for index, query := range queries {
		_,ok1:=alphabet[query[0]]
		_,ok2:=alphabet[query[1]]
		if !ok2||!ok1{
			res = append(res, 0)
		}else{
			bfs(matrix, query,alphabet)
			res = append(res, matrix[alphabet[query[0]]][alphabet[query[1]]])
		}


		if res[index] == 0 {
			res[index] = -1
		}

	}
	//print(matrix)
	return res
}

func bfs(matrix [][26]float64, query []string,alphabet map[string]int) float64 {
	// 如果访问过就返回0
	if visited[alphabet[query[0]]][alphabet[query[1]]]==1{
		return 0
	}
	// 否则就设置为1 最后退出的时候再设置为0
	visited[alphabet[query[0]]][alphabet[query[1]]]=1
	defer func() { visited[alphabet[query[0]]][alphabet[query[1]]]=0}()

	if matrix[alphabet[query[0]]][alphabet[query[1]]] != 0 {
		return matrix[alphabet[query[0]]][alphabet[query[1]]]
	}
	for key, value := range alphabet {
		if  matrix[alphabet[query[0]]][value] != 0 {
			temp := bfs(matrix,[]string{key,query[1]} ,alphabet)
			if temp != 0 {
				matrix[alphabet[query[0]]][alphabet[query[1]]]=temp*matrix[alphabet[query[0]]][value]
				return matrix[alphabet[query[0]]][alphabet[query[1]]]
			}
		}
	}
	return 0
}

func print(matrix [][26]float64){
	for _, ele1 := range matrix {
		for _, ele2 := range ele1 {
			fmt.Print(ele2)
			fmt.Print(" ")
		}
		fmt.Print("\n")
	}
	fmt.Print("\n")
}
