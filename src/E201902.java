import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    if (str.isEmpty()) {
      System.out.println("yes");
      return;
    }
    if (str.charAt(0) >= '0' || str.charAt(0) <= '9') {
      System.out.println("no");
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      if (c >= 'A' && c <= 'Z') {
        continue;
      }
      if (c >= 'a' && c <= 'z') {
        continue;
      }
      if (c >= '0' && c <= '9') {
        continue;
      }
      if (c == '_') {
        continue;
      }
      System.out.println("no");
      return;
    }
    System.out.println("yes");
  }
}
