class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        return find(matrix, matrix.length - 1, 0, target);
    }

    boolean find(int[][] matrix, int x, int y, int target) {
        if (x < 0 || y >= matrix[0].length) {
            return false;
        }
        if (matrix[x][y] > target)
            return find(matrix, x - 1, y, target);

        else if (matrix[x][y] < target)
            return find(matrix, x, y + 1, target);
        else
            return true;
    }
}
