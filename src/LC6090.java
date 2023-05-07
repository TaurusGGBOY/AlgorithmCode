class Solution {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] newArr = new int[nums.length / 2];
        for (int i = 0; i < newArr.length; i++) {
            if (i % 2 == 0) newArr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else newArr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return minMaxGame(newArr);
    }
}