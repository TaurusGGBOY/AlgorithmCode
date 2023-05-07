import java.math.BigInteger;
import java.util.Scanner;

public class E201903 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < t; i++) {
      String str = scanner.nextLine();
      String[] nums = str.split(" ");
      BigInteger bigInteger1 = new BigInteger(nums[0]);
      BigInteger bigInteger2 = new BigInteger(nums[1]);
      System.out.println(bigInteger1.mod(bigInteger2).toString());
    }
  }
}
