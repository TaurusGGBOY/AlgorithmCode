import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = 0;
        int index = s.indexOf("<div>");
        while (index != -1) {
            res++;
            s = s.substring(index + 5);
            index = s.indexOf("<div>");
        }
        System.out.println(res);
    }
}
