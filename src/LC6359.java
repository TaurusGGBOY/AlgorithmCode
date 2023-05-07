import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] res = new int[queries.length][2];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length() && j <= i + 32; j++) {
                String str = s.substring(i, j);
                if (map.containsKey(str)) continue;
                map.put(str, i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int num = queries[i][0] ^ queries[i][1];
            String str = Integer.toBinaryString(num);
            int index = map.getOrDefault(str, -1);
            if (index == -1) {
                res[i][0] = -1;
                res[i][1] = -1;
                continue;
            }
            res[i][0] = index;
            res[i][1] = index + str.length() - 1;
        }
        return res;
    }

}
