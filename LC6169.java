import java.util.Arrays;

class Solution {
    int[][] bits;

    public int longestNiceSubarray(int[] nums) {
        bits = new int[nums.length][32];
        for (int i = 0; i < nums.length; i++) {
            getBits(i, nums[i]);
        }
//        System.out.println(Arrays.deepToString(bits));
        int l = 0, r = 0;
        int[] alpha = new int[32];
        int count = 0;
        int res = 0;
        while (r < nums.length) {
            while (count == 0 && r < nums.length) {
                for (int i = 0; i < bits[r].length; i++) {
                    if (bits[r][i] == 0) continue;
                    alpha[i]++;
                    if (alpha[i] == 2) count++;
                }
                res = Math.max(res, r - l);
                r++;
            }
            if (count == 0) res = Math.max(res, r - l);
            while (count > 0 && l < r && r < nums.length) {
                for (int i = 0; i < bits[r].length; i++) {
                    if (bits[l][i] == 0) continue;
                    alpha[i]--;
                    if (alpha[i] == 1) count--;
                }
                l++;
            }
        }
        return res;
    }

    void getBits(int i, int num) {
        for (int j = 0; j < 32; j++) {
            bits[i][j] = num & 1;
            num >>= 1;
        }
    }

}
