import java.util.*;

class Solution {

    public boolean hasValidPath(char[][] grid) {
        if (grid[0][0] == ')') return false;
        if ((grid.length + grid[0].length) % 2 == 0) return false;
        Set<Integer> dp[][] = new HashSet[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[0][0].add(1);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int left = grid[i][j] == '(' ? 1 : -1;
                try {for (int num : dp[i - 1][j]) if (num + left >= 0) dp[i][j].add(num + left);} catch (Exception e) {}
                try {for (int num : dp[i][j - 1])  if (num + left >= 0)  dp[i][j].add(num + left);} catch (Exception e) {}
            }
        }
        return dp[grid.length - 1][grid[0].length - 1].contains(0);
    }
}