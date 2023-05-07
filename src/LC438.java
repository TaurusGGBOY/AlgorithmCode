import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[][] count = new int[s.length()][26];
        char[] chars = p.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        char[] sChars = s.toCharArray();
        count[0][sChars[0] - 'a'] = 1;
        for (int i = 1; i < sChars.length; i++) {
            count[i][sChars[i] - 'a'] = 1;
            for (int j = 0; j < count[0].length; j++) {
                count[i][j] += count[i - 1][j];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length()+1; i++) {
            int flag = 1;
            for (char c : map.keySet()) {
//                System.out.println(count[i + p.length() - 1][c - 'a']+" "+(i == 0 ? 0 : count[i-1][c - 'a'])+" "+map.get(c));
                if (count[i + p.length() - 1][c - 'a'] - (i == 0 ? 0 : count[i-1][c - 'a']) != map.get(c)) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                res.add(i);
            }
//            System.out.println();
        }
        return res;
    }
}