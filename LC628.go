package main

import "sort"

func maximumProduct(nums []int) int {
	sort.Ints(nums)
	// 两种情况 俩负数和一个最大的数  三个正数
	sum1 := nums[0]*nums[1]* nums[len(nums)-1]
	sum2 := nums[len(nums)-1]*nums[len(nums)-2]*nums[len(nums)-3]
	if sum1>sum2{
		return sum1
	}else{
		return sum2
	}
}