class Solution {
    public int removeDuplicates(int[] nums) {
        int dis = 0;
        int memory = -100000;
        if (nums.length <= 2) {
            return nums.length;
        }
        if (nums[0] == nums[1]) {
            memory = nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                if (memory == nums[i]) {
                    dis++;
                } else {
                    memory = nums[i];
                }
            }
            nums[i - dis] = nums[i];
        }

        nums[nums.length - 1 - dis] = nums[nums.length - 1];
        return nums.length - dis;
    }
}