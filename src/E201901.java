import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 淘汰下标分别为 2 5 0 4 1 7 3
// 失败
public class E201901 {
  long result = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {

      long n = scanner.nextLong();
      long m = scanner.nextLong();
      long k = scanner.nextLong();
      System.out.println(pos(0, n, m, k)+1);
    }
  }

  static long pos(int times, long n, long m, long k) {
    if (times == k) return m % n;
    return (pos(times + 1, n, m, k) + m) % (n - times);
  }
}
