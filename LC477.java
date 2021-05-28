class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) ==0) {
                    count++;
                }
            }
            res += (nums.length - count) * count;
        }
        return res;
    }
}