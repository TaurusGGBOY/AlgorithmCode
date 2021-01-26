package main

func numEquivDominoPairs(dominoes [][]int) int {
	count := make([]int, 100)
	res := 0
	for _, dominoe := range dominoes {
		if dominoe[0]!=dominoe[1] {
			res += count[dominoe[0]*10+dominoe[1]]+count[dominoe[1]*10+dominoe[0]]
		}else{
			res += count[dominoe[0]*10+dominoe[1]]
		}
		count[dominoe[0]*10+dominoe[1]]++
	}
	return res
}
