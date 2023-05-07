class Solution {
    int min;
    int depth;

    public int integerReplacement(int n) {
        min = Integer.MAX_VALUE;
        if (n == 1) {
            return 0;
        }
        dfs(n);
        return min;
    }

    void dfs(long n) {
        if (n == 1) {
            min = Math.min(depth, min);
            return;
        }
        if (n % 2 == 0) {
            depth++;
            dfs(n/2);
            depth--;
        }else{
            depth++;
            dfs(n+1);
            dfs(n-1);
            depth--;
        }
    }
}
