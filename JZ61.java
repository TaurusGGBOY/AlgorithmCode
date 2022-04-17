import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        int last = 0;
        for (int num : nums) {
            if (num == 0) {
                joker++;
                continue;
            }
            if (last == 0) last = num;
            else {
                if (last + 1 == num) {
                    last++;
                    continue;
                }
                while (last + 1 != num) {
                    if (joker-- == 0) return false;
                    last++;
                }
                last = num;
            }
        }
        return true;
    }
}