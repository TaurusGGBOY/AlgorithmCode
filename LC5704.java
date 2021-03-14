import java.util.Arrays;
import java.util.Stack;


class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i <= n - 1; ++i) {
            while (!mono_stack.isEmpty() && nums[mono_stack.peek()] >= nums[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && nums[mono_stack.peek()] >= nums[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (k > right[i] - 1 || k < left[i] + 1) {
                continue;
            }
            ans = Math.max(ans, (right[i] - left[i] - 1) * nums[i]);
        }
        return ans;
    }
}