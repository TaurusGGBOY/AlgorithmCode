import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        while (set.contains(original)) {
            original = original * 2;
        }
        return original;
    }
}