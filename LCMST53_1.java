class Solution {
    public int search(int[] nums, int target) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i])
                times++;
        }
		return times;   }

}