import java.util.Collections;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum == 0) {
            return 1;
        }

        // not choose any
        int res = nums.get(0) == 0 ? 0 : 1;

        // choose before i including i
        for (int i = 0; i < nums.size() - 1; i++) {
            int choosed = i + 1;
            if (choosed > nums.get(i) && choosed < nums.get(i + 1)) {
//                System.out.println(choosed + " " + nums.get(i) + " " + nums.get(i + 1));
                res++;
            }
        }

        // last one
        if (nums.size() > 1 && nums.size() > nums.get(nums.size() - 1)) {
            res++;
        }

        return res;
    }
}