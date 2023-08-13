import java.util.*;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - x; i++) {
            int num1 = nums.get(i);
            set.add(num1);
            int num2 = nums.get(i + x);

            Integer lo = set.lower(num2);
            Integer hi = set.higher(num2);
            Integer eq = set.floor(num2);

            if (eq != null && (int) eq == num2) {
                return 0;
            }

            if (lo != null) {
                res = Math.min(res, Math.abs(lo - num2));
            }

            if (hi != null) {
                res = Math.min(res, Math.abs(hi - num2));
            }
        }
        return res;
    }
}