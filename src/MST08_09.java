    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    class Solution {
        List<String> returnList;
        StringBuilder stack;
        int left = 0;
        int right = 0;

        public List<String> generateParenthesis(int n) {
            returnList = new ArrayList<>();
            stack = new StringBuilder();
            if (n == 0)
                return returnList;
            bfs(n, 0, 0, 1);
            return returnList;
        }

        public void bfs(int n, int left, int right, int isLeft) {
            if (isLeft == 1) {
                left++;
                stack.append('(');
            } else {
                right++;
                stack.append(')');
            }
            if (left > n || right > n) {
                stack.deleteCharAt(stack.length() - 1);
                return;
            }
            if (left == n && right == n) {
                returnList.add(stack.toString());
            }
            if (left < right) {
                stack.deleteCharAt(stack.length() - 1);
                return;
            }
            bfs(n, left, right, 1);
            bfs(n, left, right, 0);
            stack.deleteCharAt(stack.length() - 1);
        }
    }