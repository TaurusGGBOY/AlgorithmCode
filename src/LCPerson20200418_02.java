class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[][] ma = new int[n][n];
        int[][] temp = new int[n][n];
        for (int i = 0; i < relation.length; i++) {
            ma[relation[i][0]][relation[i][1]] = 1;
            temp[relation[i][0]][relation[i][1]] = 1;
        }
        for (int i = 0; i < k-1; i++) {
            temp = matrix(temp, ma, n);
        }
        return temp[0][n - 1];
    }

    public static int[][] matrix(int[][] p, int[][] q, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += p[i][k] * q[k][j];
                }
            }
        }
        return result;
    }
}