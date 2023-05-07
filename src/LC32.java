import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else {
                right++;
                if (right == left) max = Math.max(right * 2, max);
                else if (right > left) left = right = 0;

            }
        }
        left = right = 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') right++;
            else {
                left++;
                if (left == right) max = Math.max(left * 2, max);
                else if (left > right) left = right = 0;
            }
        }
        return max;
    }
}