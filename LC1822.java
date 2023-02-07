class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) res = -res;
            if(num == 0) return 0;
        }
        return res;
    }
}