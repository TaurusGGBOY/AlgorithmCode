import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==1&&trust.length==0)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            map.put(trust[i][0],Integer.MIN_VALUE);
            map.merge(trust[i][1], 1, (oldval, newval) -> oldval + newval);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}