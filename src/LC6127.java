import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map;
    public long countExcellentPairs(int[] nums, int k) {
        map = new HashMap<>();
        // 1 1 2 3
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            try {
                if (nums[i] == nums[i + 1]) continue;
            } catch (Exception e) {
            }
            for (int j = 0; j <= i; j++) {
                try {
                    if (nums[j] == nums[j + 1]) continue;
                } catch (Exception e) {
                }
                if (compute(nums[i], nums[j]) < k) continue;
                if (i == j) res++;
                else res += 2;
            }
        }
        return res;
    }

    int compute(int i, int j) {
        String s = i + "," + j;
        if(map.containsKey(s)) return map.get(s);
        int k = Integer.bitCount(i & j) + Integer.bitCount(i | j);
        map.put(s, k);
        return k;
    }
}