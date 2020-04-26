import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        Arrays.sort(words);
//      System.out.println(Arrays.toString(words));

        Stack<String> stack = new Stack<>();
        int maxlen = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            int flag = 1;
            for (int j = 1; j <= words[i].length(); j++) {
                if (!set.contains(words[i].substring(0,j))) {
                    flag = 0;
                    break;
                }
            }
//          System.out.println(flag);
            if (flag == 1) {
                maxlen = Math.max(maxlen, words[i].length());
                if (words[i].length() == maxlen)
                    stack.add(words[i]);
            }

        }
        return stack.pop();
    }
}