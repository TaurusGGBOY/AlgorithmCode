class Solution {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) temp ^= num;
        int bit = Integer.highestOneBit(temp);
        int[] res = new int[2];
        for (int num : nums) {
            if((bit & num) ==0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}