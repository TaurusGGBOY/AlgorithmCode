package main

func makeConnected(n int, connections [][]int) int {
	// 连通分量数量
	setCount := n
	// 冗余边数量
	remindEdges := 0
	parents := make([]int, n)
	for i := range parents {
		parents[i] = i
	}
	for _, connection := range connections {
		src := find(parents, connection[0])
		dst := find(parents, connection[1])
		if src != dst {
			merge(parents, src, dst)
			setCount--
		}else{
			remindEdges++
		}
	}
	if remindEdges < setCount-1 {
		return -1
	}
	return setCount - 1
}

func find(parents []int, index int) int {
	if index != parents[index] {
		return find(parents, parents[index])
	}
	return index
}

func merge(parents []int, src int, dst int) {
	parents[dst] = src
}