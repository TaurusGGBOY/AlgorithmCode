package main

func largeGroupPositions(s string) [][]int {
	var res [][]int
	count := 0
	start := 0
	for index := range s {
		if s[index] == s[start] {
			count++
		} else {
			if count >= 3 {
				res = append(res, []int{start, start + count - 1})
			}
			start = index
			count = 1
		}
	}
	if count >= 3 {
		res = append(res, []int{start, start + count - 1})
	}
	return res
}
