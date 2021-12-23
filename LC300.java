import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int l = 0;
                int r = len+1;
                int last = l;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (dp[m] < nums[i]) {
                        last = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                System.out.println(last);
                dp[last + 1] = nums[i];
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println();
        return len + 1;
    }
}

//0
//[10, 9, 0, 0, 0, 0, 0, 0]
//0
//[10, 2, 0, 0, 0, 0, 0, 0]
//0
//[10, 5, 0, 0, 0, 0, 0, 0]
//0
//[10, 3, 0, 0, 0, 0, 0, 0]
//0
//[10, 7, 0, 0, 0, 0, 0, 0]
//[10, 101, 0, 0, 0, 0, 0, 0]
//0
//[10, 18, 0, 0, 0, 0, 0, 0]
//
//[0, 1, 0, 0, 0, 0]
//0
//[0, 0, 0, 0, 0, 0]
//[0, 0, 3, 0, 0, 0]
//1
//[0, 0, 2, 0, 0, 0]
//[0, 0, 2, 3, 0, 0]
//
//0
//[7, 7, 0, 0, 0, 0, 0]
//0
//[7, 7, 0, 0, 0, 0, 0]
//0
//[7, 7, 0, 0, 0, 0, 0]
//0
//[7, 7, 0, 0, 0, 0, 0]
//0
//[7, 7, 0, 0, 0, 0, 0]
//0
//[7, 7, 0, 0, 0, 0, 0]
//
//0
//[10, 9, 0, 0, 0, 0]
//0
//[10, 2, 0, 0, 0, 0]
//0
//[10, 5, 0, 0, 0, 0]
//0
//[10, 3, 0, 0, 0, 0]
//0
//[10, 4, 0, 0, 0, 0]
