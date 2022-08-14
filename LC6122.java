import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int n : numsDivide) {
            gcd = gcd(Math.min(gcd, n), Math.max(gcd, n));
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0) return i;
        }
        return -1;
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}