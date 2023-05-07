// TODO 失败
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int[][] vis = new int[grid.length][grid[0].length];
        int row = grid.length;
        int col = grid[0].length;
        int round = 2 * (row + col);
        k = k % round;
        int state = 0;

        while (row > 0 && col > 0) {

        }
        return grid;
    }
}