class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                int abs = Math.abs(i - start);
                if (abs < temp) {
                    temp = abs;
                }
            }
        }
        return temp;
    }
}