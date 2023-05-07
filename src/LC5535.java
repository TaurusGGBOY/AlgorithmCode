import java.util.Stack;

class Solution {
    public int maxDepth(String s) {
        int index = s.indexOf("(");
        if(index == -1)
            return 0;
        Stack<String> stack = new Stack<>();
        stack.add("(");
        index++;
        int res =1;
        while(index<s.length())
        {
            if(s.charAt(index)=='(') {
                stack.add("(");
                res = Math.max(res, stack.size());
            }
            else if(s.charAt(index)==')')
            {
                stack.pop();
            }
            index++;
        }
        return res;
    }
}