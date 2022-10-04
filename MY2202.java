// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] parentCost = new int[n + 1];
        int[][] edge = new int[n - 1][2];
        while (n-- > 1) {
            edge[n - 1][0] = scanner.nextInt();
            edge[n - 1][1] = scanner.nextInt();
            if (edge[n - 1][0] > edge[n - 1][1]) {
                int temp = edge[n - 1][0];
                edge[n - 1][0] = edge[n - 1][1];
                edge[n - 1][1] = temp;
            }
        }
        Arrays.sort(edge, (o1, o2) -> o1[0] - o2[0]);
        int res = 0;
        for (int[] e : edge) {
            parentCost[e[1]] = e[0] - 1;
            res += e[1] - (parentCost[e[1]] + 1);
        }
        System.out.println(res);

    }
}