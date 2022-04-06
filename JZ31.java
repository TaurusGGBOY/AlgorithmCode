import java.util.Scanner;

public class JZ31 {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = a + b;
            String aString = "";
            String bString = "";
            String cString = "";
            switch (a) {
                case 0:
                    aString = "no coffee today.";
                    break;
                case 1:
                    aString = "a cup of coffee today.";
                    break;
                default:
                    aString = a + " cups of coffee today.";
                    break;
            }
            switch (b) {
                case 0:
                    bString = "no coffee today.";
                    break;
                case 1:
                    bString = "a cup of coffee today.";
                    break;
                default:
                    bString = b + " cups of coffee today.";
                    break;
            }
            switch (c) {
                case 0:
                    cString = "no coffee today.";
                    break;
                case 1:
                    cString = "a cup of coffee today.";
                    break;
                default:
                    cString = c + " cups of coffee today.";
                    break;
            }
            System.out.println("LBB made " + aString);
            System.out.println("JDG made " + bString);
            System.out.println("BOSS had " + cString);
        }

    }
}
