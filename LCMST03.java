import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] == 1)
                return num;
            else
                temp[num] = 1;
        }
        return 0;
    }
}