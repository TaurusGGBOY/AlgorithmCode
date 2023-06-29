import java.util.Scanner;

public class E20230614 {

    static int cal(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int dis = Math.abs(s1.length() - s2.length());
        // 到i的时候，已经用了j个*时的最大值
        int[][] dp = new int[s1.length()][dis];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < Math.min(dis, i); j++) {
                // 一个star都没用，那么应该等于直接比较
                int s2Pos = i - j;
                // 考虑 如果s2Pos已经超了 那么应该只有一种可能 就是加star
                if (s2Pos >= s2.length()) {
                    dp[i][j] = dp[i - 1][j] - 5;
                    continue;
                }

                int useStar = j == 0 || i == 0 ? Integer.MIN_VALUE : dp[i - 1][j - 1] - 5;
                int score = Math.abs(s1.charAt(i) - s2.charAt(s2Pos));
                int notUseStar = i == 0 ? score : dp[i - 1][j] + score == 0 ? 10 : -score;

                dp[i][j] = Math.max(useStar, notUseStar);
            }
        }

        return dp[s1.length() - 1][dis - 1];

    }


    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (--n >= 0) {
            String s1 = scanner.nextLine().split(" ")[1];
            String s2 = scanner.nextLine().split(" ")[1];
            System.out.println(cal(s1, s2));
        }
    }
}
