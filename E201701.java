import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int k = scanner.nextInt();
        double a0 = 0;
        double a1 = 1;
        double sum = (a1 + (k - 1) * d);
        // an=an-1+d=a1+(n-2)d+d=a1+(n-1)d
        if (k == 0) {
            System.out.printf("%.16f", 0f);
            return;
        }
        if (k == 1) {
            System.out.printf("%.16f", 1f);
            return;
        }
        if (k == 2) {
            System.out.printf("%.16f", 1f);
            return;
        }
        for (int i = k; i > 2; i--) {
            // System.out.printf("%.16f", sum);
            sum = a1 + (i - 2) * d + 1 / sum;
        }
        sum = 1 / (1 + 1 / sum);
        System.out.printf("%.16f", sum);
    }

}
