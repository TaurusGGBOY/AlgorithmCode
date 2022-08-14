import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int arrayNesting(int[] nums) {
        int[] vis = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int  count = 0;
            while (vis[i] == 0) {
                vis[i] = 1;
                i = nums[i];
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}