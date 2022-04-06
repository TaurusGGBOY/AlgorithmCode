import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        Map<Integer, Integer> lose = new HashMap<>();
        Map<Integer, Integer> win = new HashMap<>();
        for (int[] match : matches) {
            win.merge(match[0], 1, Integer::sum);
            lose.merge(match[1], 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : win.entrySet()) {
            if(!lose.containsKey(entry.getKey())) ans1.add(entry.getKey());
        }
        for (Map.Entry<Integer, Integer> entry : lose.entrySet()) {
            if(entry.getValue() == 1) ans2.add(entry.getKey());
        }
        Collections.sort(ans1);
        Collections.sort(ans2);
        List<List<Integer>> res = new ArrayList<>();
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}