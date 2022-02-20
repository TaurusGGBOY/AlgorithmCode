package main

func pancakeSort(arr []int) []int {
	res := make([]int, 0)
	for i := len(arr) - 1; i >= 0; i-- {
		max := 0
		for j := 0; j <= i; j++ {
			if arr[max] < arr[j] {
				max = j
			}
		}
		if max == i {
			continue
		}
		if max != 0 {
			res = append(res, max+1)
		}
		invert(arr, 0, max)
		invert(arr, 0, i)
		res = append(res, i+1)
	}
	return res
}

func invert(arr []int, start int, end int) {
	for start < end {
		temp := arr[start]
		arr[start] = arr[end]
		arr[end] = temp
		start++
		end--
	}
}

// 3241
// 4231
// 1324
// 3124
// 2134
//
