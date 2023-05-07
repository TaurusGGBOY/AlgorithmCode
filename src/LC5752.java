import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                sums[i] = sums[i - 1] + nums[i];
            }
            while (!monoStack.isEmpty() && nums[monoStack.peek()] >= nums[i]) {
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (sums[right[i] - 1] - sums[left[i] + 1] + nums[left[i] + 1]) * nums[i]);
        }
        return (int) (ans % 1000000007);
    }
}