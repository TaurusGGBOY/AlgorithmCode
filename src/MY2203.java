// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j += 2) {
                String str = s.substring(i, j);
                if (isGood(str)) count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGood(String str) {
        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) count++;
            if (count == 2) return false;
        }

        return count == 1;
    }
}