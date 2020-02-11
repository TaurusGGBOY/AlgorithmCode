class Solution {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] hirachy = new int[grid.length];
    int[] vericle = new int[grid[0].length];
    int count = 0;
    int countAfter = 0;

    for (int i = 0; i < hirachy.length; i++) {
      for (int j = 0; j < vericle.length; j++) {
        hirachy[i] = Math.max(hirachy[i], grid[i][j]);
        vericle[j] = Math.max(vericle[j], grid[i][j]);
      }
    }

    for (int i = 0; i < hirachy.length; i++) {
      for (int j = 0; j < vericle.length; j++) {
        count += grid[i][j];

        grid[i][j] = Math.min(hirachy[i], vericle[j]);
        countAfter += grid[i][j];
      }
    }
    return countAfter - count;
  }
}
