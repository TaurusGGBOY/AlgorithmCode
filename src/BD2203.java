import java.util.*;
import java.util.logging.Level;

public class Main {

    static int[][] dp;
    final static int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strs = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        char[][] matrix = new char[m][m];
        for (int i = 0; i < n; i++) {
            String s1 = scanner.nextLine();
            for (int j = 0; j < m; j++) matrix[i][j] = s1.charAt(j);
        }

        dp = new int[m][m];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        dfs(matrix, 0, 0, 0);
        if (dp[m - 1][m - 1] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[m - 1][m - 1]);
    }

    private static void dfs(char[][] matrix, int x, int y, int depth) {
        if (depth >= dp[x][y]) return;
        if (depth >= dp[matrix.length - 1][matrix[0].length - 1]) return;
        if (matrix.length + matrix[0].length - 2 == dp[matrix.length - 1][matrix[0].length - 1]) return;
        dp[x][y] = depth;
        for (int[] d : directions) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length) continue;
            if (matrix[x][y] == 'r' && matrix[nextX][nextY] == 'd') continue;
            if (matrix[x][y] == 'e' && matrix[nextX][nextY] == 'r') continue;
            if (matrix[x][y] == 'd' && matrix[nextX][nextY] == 'e') continue;
            dfs(matrix, x + d[0], y + d[1], depth + 1);
        }
    }
}
