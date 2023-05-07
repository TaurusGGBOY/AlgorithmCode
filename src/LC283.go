func moveZeroes(nums []int)  {
start := 0

for i := 0; i<len(nums); i++{
if nums[i] != 0{
nums[start] = nums[i]
start = start + 1
}

}
for; start<len(nums);start++{
nums[start] = 0
}
}
