import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    int[] dp;
    int[] vis;
    Map<Integer, Set<Integer>> next;

    public int minJumps(int[] arr) {
        dp = new int[arr.length];
        vis = new int[arr.length];
        next = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            dp[i] = i;
            Set<Integer> set = next.getOrDefault(arr[i], new HashSet<>());
            set.add(i);
            next.put(arr[i], set);
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, i);
            vis[i] = 1;
         }
//        System.out.println();
        return dp[arr.length - 1];
    }

    void dfs(int[] arr, int pos) {
        if (pos > arr.length || pos < 0 || vis[pos] == 1) return;
//        System.out.println(pos);
        Set<Integer> set = next.getOrDefault(arr[pos], new HashSet<>());
        if (!set.isEmpty()) for (int i : set) if (dp[i] > dp[pos] + 1) dp[i] = dp[pos] + 1;
        if (pos + 1 < arr.length && dp[pos + 1] > dp[pos] + 1) dp[pos + 1] = dp[pos] + 1;
        if (pos - 1 >= 0 && dp[pos - 1] > dp[pos] + 1) dp[pos - 1] = dp[pos] + 1;
        if (!set.isEmpty()) for (int i : set) if (dp[i] == dp[pos] + 1) dfs(arr, i);
        if (pos + 1 < arr.length && dp[pos + 1] == dp[pos] + 1) dfs(arr, pos + 1);
        if (pos - 1 >= 0 && dp[pos - 1] == dp[pos] + 1) dfs(arr, pos - 1);
    }
}

//3
//0
//1
//2
//3