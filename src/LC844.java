import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getStr(S).equals(getStr(T));
    }

    String getStr(String str) {
        Stack<Character> stack = new Stack<>();

        char[] strC = str.toCharArray();
        for (char c : strC) {
            if (c == '#')
                try {
                    stack.pop();
                } catch (Exception ignored) {

                }

            else
                stack.add(c);
        }
        char[] res = new char[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return String.valueOf(res);
    }
}