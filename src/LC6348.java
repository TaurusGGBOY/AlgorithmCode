import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Character> set = new HashSet<>();

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counter = new int[words.length];
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        counter[0] = check(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            counter[i] = (check(words[i]) ? 1 : 0) + counter[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int right = queries[i][0] == 0 ? 0 : counter[queries[i][0] - 1];
            res[i] = counter[queries[i][1]] - right;
        }
        return res;
    }

    boolean check(String w) {
        char c1 = w.charAt(0);
        char c2 = w.charAt(w.length() - 1);
        return set.contains(c1) && set.contains(c2);
    }
}