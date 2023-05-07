import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minCapability(int[] nums, int k) {
        int[] values = Arrays.copyOf(nums, nums.length);
        Arrays.sort(values);
        int l = 0, r = values.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean flag = check(nums, k, values[m]);
            if (flag) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return values[r];
    }

    boolean check(int[] nums, int k, int v) {
        boolean select = false;
        int counter = 0;
        for (int num : nums) {
            if (num > v) {
                select = false;
                continue;
            }
            // 如果上一个选了，不选
            if (select) {
                select = false;
                continue;
            }
            // 如果上一个没选 我选
            select = true;
            counter++;
            if (counter >= k) return true;
        }
        return false;
    }
}