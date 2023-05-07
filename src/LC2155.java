import java.util.*;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int l = 0;
        int r = 0;
        for (int num : nums) {
            if (num == 1) r++;
        }
        int max = r;
        for (int i = 1; i < nums.length + 1; i++) {
            int num = nums[i - 1];
            l += num == 0 ? 1 : 0;
            r -= num == 1 ? 1 : 0;
            if (l + r > max) res.clear();
            if (l + r >= max) res.add(i);
            max = Math.max(l + r, max);
        }
        return res;
    }
}