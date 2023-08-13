import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public long minCost(int[] nums, int x) {
        int[] min = Arrays.copyOf(nums, nums.length);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        long sum = res;
//        System.out.println();
        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[(i - j + nums.length) % nums.length] < min[i]) {
                    sum -= min[i] - nums[(i - j + nums.length) % nums.length];
                    min[i] = nums[(i - j + nums.length) % nums.length];
                }
            }
            sum += x;
//            System.out.println(sum);
            res = Math.min(sum, res);
        }
        return res;
    }
}