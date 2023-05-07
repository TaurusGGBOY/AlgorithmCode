// Ê§°Ü
class Solution {
  public int surfaceArea(int[][] grid) {
    int[] square1 = new int[grid.length];
    int sum = 0;
    int[] square2 = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        sum += grid[i][j] > 0 ? 1 : 0;
        if (grid[i][j] > square1[i]) {
          sum += grid[i][j] - square1[i];
          square1[i] = grid[i][j];
        }
        if (grid[i][j] > square2[j]) {
          sum += grid[i][j] - square2[j];
          square2[j] = grid[i][j];
        }
      }
    }
    return 2 * sum;
  }
}
