package main

func findLengthOfLCIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	start := 0
	count := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] <= nums[i-1] {
			start = i
		} else {
			if i-start+1 > count {
				//fmt.Printf("%d %d\n", i, start)
				count = i - start + 1
			}
		}
	}
	return count
}
