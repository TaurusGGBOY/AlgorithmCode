import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reversePrefix(String word, char ch) {
        if (!word.contains(String.valueOf(ch))) {
            return word;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = word.toCharArray();
        for (char c : chars) {
            stack.push(c);
            if (c == ch) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        if (word.indexOf(ch) + 1 < word.length()) {
            stringBuilder.append(word.substring(word.indexOf(ch)+1));
        }
        return stringBuilder.toString();
    }
}