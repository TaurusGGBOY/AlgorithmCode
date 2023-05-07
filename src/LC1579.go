package main

// 连通分量
var connect_var []int
// 可删除的边的数量
var can_delete int
var parents [][]int

func maxNumEdgesToRemove(n int, edges [][]int) int {
	can_delete = 0
	connect_var = make([]int, 3)
	connect_var[1] = n
	connect_var[2] = n
	parents = make([][]int, 3)
	parents[1] = make([]int, n+1)
	parents[2] = make([]int, n+1)

	for i := 1; i <= n; i++ {
		parents[1][i] = i
		parents[2][i] = i
	}

	// 优化1：把type_i不是3的加入进去 二次扫描的时候就可以节约时间
	remind_edge := make([][]int, 0)
	for _, edge := range edges {
		if edge[0] == 3 {
			// 优化2： 两者其实是同步的 那么只需要在没有环的时候处理最后一对即可
			merge_res := merge_set(edge[1], edge[2], 1)
			if merge_res[0] == 1 {
				merge_set(merge_res[1], merge_res[2], 2)
			}
		} else {
			remind_edge = append(remind_edge, []int{edge[0], edge[1], edge[2]})
		}
	}

	for _, edge := range remind_edge {
		merge_set(edge[1], edge[2], edge[0])
	}

	// 防止有连通分量为0的情况
	if connect_var[1] <= 1 && connect_var[2] <= 1 {
		return can_delete
	}
	return -1
}

func merge_set(src int, dst int, type_i int) []int {
	f1 := find_parent(src, type_i)
	f2 := find_parent(dst, type_i)
	// 判断是否有环 如果有环就可以删掉 如果是公共边只删 一次
	if f1 == f2 {
		can_delete++
		return []int{0, f1, f2}
	}
	parents[type_i][f1] = f2
	connect_var[type_i]--
	return []int{1, f1, f2}
}

func find_parent(index int, type_i int) int {
	temp := parents[type_i][index]
	if temp != index {
		// 就这一句……是路径压缩
		parents[type_i][index]=find_parent(temp, type_i)
		return parents[type_i][index]
	}
	return index
}
