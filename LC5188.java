import java.util.Arrays;

class TreeAncestor {
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        dp = new int[n + 1][n + 1];
        for(int i =0;i<parent.length;i++)
        {
            dp[i][]
        }
    }

    public int getKthAncestor(int node, int k) {
       return dp[node][k];
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */