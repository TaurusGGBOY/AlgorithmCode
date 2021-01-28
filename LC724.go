package main

func pivotIndex(nums []int) int {
	sum := 0
	for _, num := range nums {
		sum+=num
	}
	left :=0
	for index, num := range nums {
		if 2*left+num==sum{
			return index
		}else{
			left += num
		}
	}
	return -1
}