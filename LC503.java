import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (res[i] == Integer.MIN_VALUE) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        res[i] = nums[j];
                        break;
                    }
                }
            }
            res[i] = res[i] == Integer.MIN_VALUE ? -1 : res[i];
        }
        return res;
    }
}