import java.util.*;

public class Main {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        String[] strs = s.split("><");
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < strs.length; i++) {
            int start = 0;
            String str = strs[i];
            int end = str.length() - 1;
            if (i == 0) start++;
            if (i == strs.length - 1) end--;
            if (str.charAt(start) == '/') {
                stringBuilder.append(deque.pollLast()).append(" ");
                continue;
            } else if (str.charAt(end) == '/') {
                stringBuilder.append(str.substring(start, end)).append(" ");
                continue;
            } else {
                deque.offerLast(str.substring(start, end));
            }
        }

        System.out.println(stringBuilder.toString().trim());

    }
}
