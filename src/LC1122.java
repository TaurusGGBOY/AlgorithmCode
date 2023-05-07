import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        String[] strs = new String[dominoes.length];
        for (int i = 0; i < dominoes.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (dominoes[i][0] > dominoes[i][1]) {
                stringBuilder.append(dominoes[i][1]);
                stringBuilder.append(dominoes[i][0]);
            } else {
                stringBuilder.append(dominoes[i][0]);
                stringBuilder.append(dominoes[i][1]);
            }
            strs[i] = stringBuilder.toString();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map.merge(str, 1, (oldval, newval) -> oldval + newval);
        }

        int count=0;
        // 1+2+..+sum-1
        for (int sum:map.values())
        {
            count += sum*(sum-1)/2;
        }
        return count;
    }

}