import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] * nums[j];
                if (sums.containsKey(sum)) {
                    int time = sums.get(sum);
                    count += time;
                    sums.put(sum, time + 1);
                } else {
                    sums.put(sum, 1);
                }
            }
        }
        return count * 8;
    }
}



