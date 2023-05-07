import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        while (q-- > 0) {
            String s = scanner.nextLine();
            if (s.length() == 1) {
                System.out.println("Yes");
                continue;
            }
            char[] chars = s.toCharArray();
            int[][] dp = new int[s.length()][2];

            for (int i = 0; i < chars.length-1; i++) {
                char c1 = chars[0];
                char c2 = chars[1];
                if(c1=='0' && c2=='0'){
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 2][1];
                }else if(c1=='0' && c2=='1'){

                }else if(c1=='1' && c2=='0'){

                }else if(c1=='1' && c2=='1'){

                }

            }
            System.out.println(Arrays.deepToString(dp));
            System.out.println((dp[s.length() - 1][0] | dp[s.length() - 1][1]) == 1 ? "Yes" : "No");
        }
    }
}
