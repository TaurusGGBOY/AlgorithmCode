import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (map.containsKey(answer + 1)) {
                int temp = map.get(answer + 1);
                if (temp > 1)
                    map.put(answer + 1, temp - 1);
                else
                    map.remove(answer+1);
            } else {
                count += answer + 1;
                if (answer > 0)
                    map.put(answer + 1, answer);
            }
        }
        return count;
    }
}