package main

func regionsBySlashes(grid []string) int {
	// 对所有格子进行编号
	parents := map[int]int{}
	// 上右下左 0 1 2 3
	//fmt.Printf("%d, %d\n", len(grid), len(grid[0]))
	for i := 0; i < 4*len(grid)*len(grid[0]); i++ {
		parents[i] = i
	}
	for i, row := range grid {
		for j, ele := range row {
			// 对于第i行的第j个符号来说 上是：4*(i*len(grid[0])+j)
			first := 4 * (i*len(grid[0]) + j)
			if i > 0 {
				mergeSet(parents, first, first-4*len(grid[0])+2)
			}
			if j >0 {
				mergeSet(parents, first+3, first-3)
			}
			if ele == '/' {
				mergeSet(parents, first, first+3)
				mergeSet(parents, first+2, first+1)
			} else if ele == '\\' {
				mergeSet(parents, first+1, first)
				mergeSet(parents, first+2, first+3)
			} else {
				mergeSet(parents, first+1, first)
				mergeSet(parents, first+2, first)
				mergeSet(parents, first+3, first)
			}
		}
	}

	res := map[int]bool{}
	for key, _ := range parents {
		//fmt.Printf("grid:%d, key:%d, value:%d\n", key/4+1, key, value)
		res[findParents(parents, key)] = true
	}
	//for index, a := range res {
	//	fmt.Printf("res: index:%d a:%d\n", index,a)
	//}
	//fmt.Printf("\n")
	return len(res)
}

func mergeSet(parents map[int]int, src int, dst int) {
	parents[findParents(parents, parents[src])] = findParents(parents, parents[dst])
}

func findParents(parents map[int]int, index int) int {
	if index != parents[index] {
		return findParents(parents, parents[index])
	}
	return index
}
