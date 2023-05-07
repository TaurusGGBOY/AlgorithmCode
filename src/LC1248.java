class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] % 2 == 1 ? 1 : 0;
            dp[i] = count;
        }
        int res = 0;
        int startPos = 1;
        int firstTime;
        for (int i = 0; i < nums.length; i++) {
            firstTime = 1;
            if (dp[i] == k)
                res++;
            for (int j = startPos; j < nums.length; j++) {

                if (dp[j] - dp[i] == k) {
                    if (firstTime == 1) {
                        firstTime = 0;
                        startPos = j;
                    }
                    res++;
                } else if (dp[j] - dp[i] > k)
                    break;

            }
        }
        return res;
    }

}