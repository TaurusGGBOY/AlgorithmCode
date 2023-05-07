import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
            map.merge(time[i], 1, (oldval, newval) -> oldval + newval);
        }
        int sum = 0;
        for (int value : time) {
            if (value == 30) {
                sum += map.get(30) - 1;
            } else if (value == 0) {
                sum += map.get(0) - 1;
            } else {
                sum += map.getOrDefault(60 - value, 0);
            }
        }
        return sum / 2;
    }
}