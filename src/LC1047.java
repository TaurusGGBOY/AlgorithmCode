import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
            }else{
                stack.offerLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}