class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int x = 0, y = 0;
        for (int i = 0; i < row.length; i++) {
            if ((row[i] & 1) == 1) x++;
        }
        for (int i = 0; i < col.length; i++) {
            if ((col[i] & 1) == 1) y++;
        }
        return y * (row.length - x) + x * (col.length - y);
    }
}