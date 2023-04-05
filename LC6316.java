import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxScore(int[] nums) {
        long sum = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
                res++;
            } else {
                list.add(nums[i]);
            }
        }
        list.sort((o1, o2) -> o2 - o1);
        for (int num : list) {
            if (sum + num > 0) {
                res++;
                sum += num;
            }
        }
        return res;
    }

}