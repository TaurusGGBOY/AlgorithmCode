import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (char c : arr) {
            if (set.contains(c))
                stack.add(c);
        }
        for (char c : arr) {
            if (set.contains(c))
                stringBuilder.append(stack.pop());
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }
}