import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] temp = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            temp[i] = score[i];
        }
        Arrays.sort(temp, (o1, o2) -> o2 - o1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i + 1);
        }
        String[] strs = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] res = new String[score.length];
        for (int i = 0; i < res.length; i++) {
            int rank = map.get(score[i]);
            res[i] = rank <= 3 ? strs[rank - 1] : String.valueOf(rank);
        }
        return res;
    }
}