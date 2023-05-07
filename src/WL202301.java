import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long res = scanner.nextLong();
        long sum = Math.max(0, res);
        long max = res;
        for (int i = 1; i < n; i++) {
            long temp = scanner.nextLong();
            max = Math.max(max, temp);
            if (sum + temp < 0) sum = 0;
            else {
                sum += temp;
                res = Math.max(sum, res);
            }
        }
        System.out.println(max <= 0 ? max : res);
    }
}
