class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int p = 0;
        int n = 0;
        for (int num : nums) {
            if (num < 0) {
                neg[n++] = num;
            }else{
                pos[p++] = num;
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < pos.length; i++) {
            res[2 * i] = pos[i];
            res[2 * i+1] = neg[i];
        }
        return res;
    }
}