import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}