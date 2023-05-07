// TODO 失败
import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            list.add(nums[i]);
        }
        List<Long> temp = new ArrayList<>();
        list.forEach((e) -> {
            temp.add(Long.valueOf(e));
        });
        temp.sort(Comparator.reverseOrder());
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) - temp.get(i + 1) <= t) {
                return true;
            }
        }
        for (int i = k + 1; i < nums.length; i++) {
            temp.add(Long.valueOf(nums[i]));
            temp.remove(temp.indexOf(Long.valueOf(nums[i - (k + 1)])));
            temp.sort(Comparator.reverseOrder());
            for (int j = 0; j < temp.size() - 1; j++) {
                if (temp.get(j) - temp.get(j + 1) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}