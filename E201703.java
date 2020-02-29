import java.util.Scanner;

public class Main {
    static int[] matrix = new int[300001];
    static int[] im = new int[3000001];
    static int[] jm = new int[3000001];

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 0; i < 300001; i++)
            matrix[i] = -1;
        matrix[1] = 1;
        if (q == 1)
            System.out.println(primary(n));
        else
            System.out.println(mid(n));
    }

    static int primary(int n) {
        if (matrix[n] != -1)
            return matrix[n];
        int count = 0;
        for (int i = 1; i < Math.sqrt((double) n); i++) {
            if (n == i * (n / i)) {
                count += 2;
            }
        }
        if (((int) Math.sqrt((double) n) * (int) Math.sqrt((double) n)) == n)
            count++;
        matrix[n] = count;
        System.out.print("n count ");
        System.out.print(n);
        System.out.print(" ");
        System.out.print(count);
        System.out.print(" ���� ");
        System.out.println(violet(n));
        return count;
        // return violet(n);
    }

    static int mid(int n) {
        int count = 0;
        for (int sum = 1; sum < Math.sqrt((double) n); sum++) {
            count += primary(sum) * primary(n - sum) * 2;
        }
        if (((int) Math.sqrt((double) n) * (int) Math.sqrt((double) n)) == n)
            count += primary((int) Math.sqrt((double) n)) * primary((int) Math.sqrt((double) n));
        // System.out.print("n count ");
        // System.out.print(n);
        // System.out.print(" ");
        // System.out.print(count);
        // System.out.print(" ���� ");
        // System.out.println(violetMid(n));
        return violetMid(n);
    }

    static int violet(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                count++;
        return count;
    }

    static int violetMid(int n) {
        int count = 0;
        for (int i = 1; i <= n - 1; i++) {
            count += primary(i) * primary(n - i);
            System.out.print("i j ");
            System.out.print(i);
            System.out.print(" ");
            System.out.println(n - i);

        }
        return count;
    }
}
