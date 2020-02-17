class Solution {
	public int maxValue(int[][] grid) {
		if(grid.length==1&&grid[0].length==1)
			return grid[0][0];
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0]=grid[0][0];
		for(int i=1;i<grid.length-1;i++)
			dp[i][0]=grid[i][0]+dp[i-1][0];
		for(int i=1;i<grid[0].length-1;i++)
			dp[0][i]=grid[0][i]+dp[0][i-1];
		for(int i=1;i<grid.length;i++)
		{
			for(int j =1;j<grid[0].length;j++)
			{
				
			}
		}
	}
}