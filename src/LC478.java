import java.util.Scanner;

public class LC478 {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();

            boolean LJJ = true;
            while (true) {
                int sqrt = (int) Math.sqrt(n);
                if (sqrt * sqrt == n)
                    break;
                n = n - sqrt * sqrt;
                LJJ = !LJJ;
            }
            if (LJJ)
                System.out.println("JDG will get takeaways!");
            else
                System.out.println("LJJ will get takeaways!");
        }
    }

}
