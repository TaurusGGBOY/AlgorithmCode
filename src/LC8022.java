import java.util.HashSet;
import java.util.Set;

class Solution {
    public long minimumPossibleSum(int n, int target) {
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 2 * n; i++) {
            if (!set.contains(target - i)) {
                set.add(i);
                sum += i;
            }
            if (set.size() == n) {
                break;
            }
        }
        return sum;
    }
}