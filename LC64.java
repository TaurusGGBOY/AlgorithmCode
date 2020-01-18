class Solution {

	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int[][] Min = new int[row][col];

		Min[0][0] = grid[0][0];
		for (int i = 1; i < col; i++) {
			Min[0][i] += Min[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < row; i++) {
			Min[i][0] += Min[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				Min[i][j] = grid[i][j] + Math.min(Min[i - 1][j], Min[i][j - 1]);
			}
		}
		return Min[grid.length - 1][grid[0].length - 1];
	}

}