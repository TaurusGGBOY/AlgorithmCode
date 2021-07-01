import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<String>();
    int leftCount = 0;
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(1, n);
        return set;
    }

    private void dfs(int depth, int n) {
        // System.out.println(stringBuilder.toString());
        if (depth == 2 * n + 1) {
            if (leftCount == 0)
                set.add(stringBuilder.toString());
            return;
        }
        if (leftCount < n) {
            leftCount++;
            stringBuilder.append("(");
            dfs(depth + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            leftCount--;
        }

        if (leftCount > 0) {
            leftCount--;
            stringBuilder.append(")");
            dfs(depth + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            leftCount++;
        }
    }

}