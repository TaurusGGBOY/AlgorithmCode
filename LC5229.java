import java.util.Arrays;
import java.util.logging.Level;

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getRes(nums1, nums2), getRes(nums2, nums1));
    }

    int getRes(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        int[] dp = new int[nums1.length];
        dp[0] = Math.max(nums2[0] - nums1[0], 0);
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int win = nums2[i] - nums1[i];
            if (dp[i - 1] + win < 0) dp[i] = 0;
            else {
                dp[i] = dp[i - 1] + win;
                max = Math.max(dp[i], max);
            }
        }
        return sum1 + max;
    }

}