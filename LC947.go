// TODO 失败
package main

func removeStones(stones [][]int) int {
	n := len(stones)
	graph := make([][]int, n)
	for i, p := range stones {
		for j, q := range stones {
			if p[0] == q[0] || p[1] == q[1] {
				graph[i] = append(graph[i], j)
			}
		}
	}
	vis := make([]bool, n)
	var dfs func(int)
	dfs = func(v int) {
		vis[v] = true
		for _, w := range graph[v] {
			if !vis[w] {
				dfs(w)
			}
		}
	}
	cnt := 0
	for i, v := range vis {
		if !v {
			cnt++
			dfs(i)
		}
	}
	return n - cnt
}
