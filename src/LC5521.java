class Solution {
    static long res;

    public int maxProductPath(int[][] grid) {
        long maxSum = grid[0][0];
        long minSum = grid[0][0];
        res = grid.length==1&&grid[0].length==1?grid[0][0]:-1;
        dfs(1,0,grid,maxSum,minSum);
        dfs(0,1,grid,maxSum,minSum);
        return res>=0?(int)(res%1000000007):-1;
    }

    public void dfs(int i, int j , int[][] grid, long maxSum, long minSum)
    {
        if(i>=grid.length||j>=grid[0].length)
            return;
        if(grid[i][j]==0)
        {
            res = Math.max(0, res);
            return;
        }
        long temp = maxSum;
        maxSum = Math.max(maxSum * grid[i][j], minSum * grid[i][j]);
        minSum = Math.min(temp * grid[i][j], minSum * grid[i][j]);
        if(i==grid.length-1&&j==grid[0].length-1)
        {
            res = Math.max(res, maxSum);
//            System.out.println(res);
            return;
        }
        dfs(i+1,j,grid,maxSum,minSum);
        dfs(i,j+1,grid,maxSum,minSum);
    }
}