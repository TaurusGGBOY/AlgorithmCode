import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 1. 从后往前维护一个最大栈

        // 2. 维护一个第二大值
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
//                System.out.println(nums[i]+" "+nums[stack.peek()]+" "+second);
                return true;
            }
            // 如果当前的值大于栈中元素 就要弹出栈中元素
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                second = nums[stack.pop()];
            }
            stack.push(i);
        }
        return false;
    }
}