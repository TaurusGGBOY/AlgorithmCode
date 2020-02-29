import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ������ ����д
        String string = scanner.nextLine();
        StringBuilder sBuilder = new StringBuilder();

        int count = 1;
        char lastWord = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == lastWord)
                count++;
            else {
                sBuilder.append(count);
                sBuilder.append(lastWord);
                count = 1;
                lastWord = string.charAt(i);
            }
        }
        sBuilder.append(count);
        sBuilder.append(lastWord);
        System.out.println(sBuilder.toString());
    }
}
