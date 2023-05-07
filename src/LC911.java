import java.util.Scanner;

public class LC911 {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int sum = 0;
            int ji = 1;
            for (int j = 1; j <= n; j++) {
                int temp = scanner.nextInt();
                sum += temp;
                ji *= 2;

            }
            System.out.println(ji * sum / 2);
        }

    }
}
