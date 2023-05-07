import java.util.*;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] increaseByDay = new int[security.length];
        int[] decreaseByDay = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) increaseByDay[i] = increaseByDay[i - 1];
            else increaseByDay[i] = i;
        }
        decreaseByDay[security.length - 1] = security.length - 1;
        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) decreaseByDay[i] = decreaseByDay[i + 1];
            else decreaseByDay[i] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (i - increaseByDay[i] >= time && decreaseByDay[i] - i >= time) {
                res.add(i);
            }
        }
        return res;
    }
}