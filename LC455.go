package main

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(s)
	sort.Ints(g)
	res := 0
	i := len(g) - 1
	j := len(s) - 1
	for i >= 0 && j >= 0 {
		if s[j] >= g[i] {
			res++
			j--
			i--
		} else {
			i--
		}
	}
	return res
}
