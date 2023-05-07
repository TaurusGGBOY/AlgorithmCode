import java.util.Arrays;
import java.util.Scanner;
// 失败
public class E201905 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[][] dp = new int[1001][1001];
    int[] sum = new int[1001];
    for (int[] ints : dp) Arrays.fill(ints, 1);
    for (int i = 1; i < dp.length - 1; i++) {
      for (int j = 1; j <= i; j++) {
        sum[j] += dp[i][j];
        dp[i][j + 1] = sum[j];
        if (i == m && j + 1 == n) {
          System.out.println(dp[m][n]);
          return;
        }
      }
    }
  }
}
