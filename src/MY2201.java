// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque1.offerLast('a');
        }

        while (!deque1.isEmpty()) {
            char c1 = deque1.pollLast();
            deque2.offerLast(c1);

            while (true) {
                char c3 = deque2.pollLast();
                if (c3 == 'z') break;
                if (deque2.isEmpty()) {
                    deque2.offerLast(c3);
                    break;
                }
                char c4 = deque2.pollLast();
                if (c4 == 'z') break;
                if (c3 == c4) deque2.offerLast((char) (c3 + 1));
                else {
                    deque2.offerLast(c4);
                    deque2.offerLast(c3);
                    break;
                }
            }
        }

        char[] chars = new char[deque2.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = deque2.pollLast();
        }

        System.out.println(String.valueOf(chars));

    }
}