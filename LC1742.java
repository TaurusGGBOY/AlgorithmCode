import java.util.*;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            int sum = 0;
            for (char c : chars) {
                sum += c - '0';
            }
            map.merge(sum, 1, Integer::sum);
        }
        int res = 0;
        for (int value : map.values()) {
            res = Math.max(value, res);
        }
        return res;
    }
}