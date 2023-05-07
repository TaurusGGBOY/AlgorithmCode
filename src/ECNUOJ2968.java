import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            System.out.print("case #");
            System.out.print(j);
            System.out.println(":");
            int a = scanner.nextInt();
            int[] money = new int[]{100, 50, 20, 10, 5, 1};
            int[] res = new int[money.length];
            int remind = a;
            for (int i = 0; i < money.length; i++) {
                res[i] = remind / money[i];
                remind = remind - res[i] * money[i];
                System.out.print(res[i]);
                if (i < money.length - 1)
                    System.out.print(" ");

            }
            System.out.println();
        }

    }
}