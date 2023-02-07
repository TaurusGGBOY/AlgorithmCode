import java.util.*;

class Solution {
    int[] dp;
    int max;
    int[] vis;
    Map<Integer, Set<Integer>> map;

    public int maximumInvitations(int[] favorite) {
        dp = new int[favorite.length];
        redVis = new int[favorite.length];
        max = 0;
        map = new HashMap<>();
        for (int i = 0; i < favorite.length; i++) {
            if (redVis[i] != 0) {
                continue;
            }
            int val = dfs(favorite, i);
            dp[i] = val;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    int dfs(int[] favorite, int i) {
        if (dp[i] == 0 && redVis[i] == 1) {
            return 0;
        }
        if (dp[i] != 0 || redVis[i] == 1) {
            return dp[i];
        }
        System.out.println("i:"+i+"in");
        redVis[i] = 1;
        int val = dfs(favorite, favorite[i]);
        Set<Integer> set = map.getOrDefault(favorite[i], new HashSet<>());
        if (set.contains(i)) {
            dp[i] = Math.max(val+1, dp[favorite[i]]-dp[i]+1);
        }
        System.out.println("i:"+i+" dp[i] "+dp[i]+" out");

        max = Math.max(dp[i], max);
        return dp[i];
    }
}