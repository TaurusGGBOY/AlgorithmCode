class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int dis = nums[1] - nums[0];
        int[] maxLen = new int[2];
        maxLen[0] = dis < 0 ? 1 : 0;
        maxLen[1] = dis > 0 ? 1 : 0;

        for (int i = 1; i < nums.length - 1; i++) {
            dis = nums[i + 1] - nums[i];
            if (dis < 0) {
                maxLen[0] = Math.max(maxLen[0], maxLen[1] + 1);
            } else if (dis > 0) {
                maxLen[1] = Math.max(maxLen[1], maxLen[0] + 1);
            }
        }
        return Math.max(maxLen[0], maxLen[1]) + 1;
    }
}