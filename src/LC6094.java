import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public long distinctNames(String[] ideas) {
        Set<String> set = new HashSet<>(Arrays.asList(ideas));
        int[][] canChange = new int[26][26];
        boolean[][] graph = new boolean[ideas.length][26];

        for (int i = 0; i < ideas.length; i++) {
            StringBuilder stringBuilders = new StringBuilder(ideas[i]);
            for (int j = 0; j < canChange[0].length; j++) {
                stringBuilders.setCharAt(0, (char) ('a' + j));
                if (!set.contains(stringBuilders.toString())) {
                    canChange[ideas[i].charAt(0) - 'a'][j]++;
                    graph[i][j] = true;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < ideas.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (!graph[i][j]) continue;
                res += canChange[j][ideas[i].charAt(0)-'a'];
//                if (canChange[j][i] != 0) System.out.println(ideas[i] + " " + (char) ('a' + i) + " " + (char) ('a' + j) + " " + canChange[j][i]);
            }
        }

        return res;


    }
}