import java.util.*;

class Solution {
    List<String> res;
    int open;
    int close;
    StringBuilder stringBuilder;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        stringBuilder = new StringBuilder();
        open = n - 1;
        close = n;
        dfs('(');
        return res;
    }

    void dfs(char c) {
        if (open < 0 || close < 0 || (open > close)) return;
        stringBuilder.append(c);
        if (open == close && open == 0) {
            res.add(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }
        open--;
        dfs('(');
        open++;
        close--;
        dfs(')');
        close++;
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}