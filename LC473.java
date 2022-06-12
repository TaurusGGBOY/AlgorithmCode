import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        // 1 1 1 1 1 3 4 4 4
        // 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 3
        Arrays.sort(matchsticks);
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        return dfs(matchsticks.length - 1, matchsticks, new int[4], sum / 4);
    }

    private boolean dfs(int i, int[] matchsticks, int[] edges, int len) {
        if (i < 0) return true;
        for (int j = 0; j < edges.length; j++) {
            edges[j] += matchsticks[i];
            if (edges[j] <= len && dfs(i - 1, matchsticks, edges, len)) return true;
            edges[j] -= matchsticks[i];
        }
        return false;
    }
}