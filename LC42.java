import java.util.*;

class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int top = stack.pollLast();
                if (stack.isEmpty()) break;
                int left = stack.peekLast();
                res += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.offerLast(i);
        }
        return res;
    }
}