import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int count = 0;
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                if (a <= 10)
                    count++;
            }
            System.out.println(count);
        }

    }
}
