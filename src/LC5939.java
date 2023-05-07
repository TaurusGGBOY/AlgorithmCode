import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i <= 2 * k && i < nums.length; i++) {
            sum += nums[i];
        }
        if (k == 0) {
            return nums;
        }
        if (2 * k > nums.length) {
            return res;
        }
        int pos = k;
        res[pos++] = (int) (sum / (2 * k + 1));
        for (int i = 2 * k + 1; i < nums.length; i++, pos++) {
            sum -= nums[i - 2 * k - 1];
            sum += nums[i];
            res[pos] = (int) (sum / (2 * k + 1));
        }

        return res;
    }
}