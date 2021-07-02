import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> set;
    boolean[] visit;

    public String[] permutation(String s) {
        set = new HashSet<>();
        visit = new boolean[s.length()];
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(chars, 0, stringBuilder);
        return set.stream().toArray(String[]::new);
    }

    public void backtrack(char[] chars, int i, StringBuilder stringBuilder) {
        if (i == chars.length) {
            set.add(stringBuilder.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] =true;
            stringBuilder.append(chars[j]);
            backtrack(chars, i + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visit[j] = false;
        }
    }
}