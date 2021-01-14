package main

func prefixesDivBy5(A []int) []bool {
	count := 0
	var res []bool
	for _, element := range A {
		count = (count*2 + element) % 5

		res = append(res, (count%5) == 0)
	}
	return res
}
