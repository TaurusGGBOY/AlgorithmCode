import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] broken = new int[101];
        for (int i = 0; i < k; i++) {
            int num = scanner.nextInt();
            broken[num] = 1;
        }

        int[] step = new int[101];
        step[0] = 1;
        if (broken[1] == 1)
            step[1] = 0;
        else
            step[1] = 1;

        if (broken[2] == 1)
            step[2] = 0;
        else {
            step[2] = step[0] + step[1];
        }

        for (int i = 3; i <= n; i++) {
            if (broken[i] == 1) {
                step[i] = 0;
                continue;
            }
            step[i] += step[i - 3] + step[i - 2] + step[i - 1];
        }
        // for (int i = 0; i < 101; i++) {
        // System.out.print(step[i]);
        // System.out.print(" ");
        // }
        System.out.println(step[n]);
    }
}
