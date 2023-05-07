import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.offer(c);
            }else{
                if (c == stack.peek()) {
                    continue;
                } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    stack.offer(c);
                }else{
                    stack.clear();
                    break;
                }
            }
        }
        System.out.println(stack.size());
    }
}