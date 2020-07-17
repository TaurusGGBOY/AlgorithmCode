import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        int pos1 = 0, pos2 = 0, pos3 = 0;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 0; i < n; i++) {
            int target = Math.min(Math.min(nums[pos1] * 2, nums[pos2] * 3), nums[pos3] * 5);
            if (nums[pos1] * 2 == target)
                pos1++;
            if (nums[pos2] * 3 == target)
                pos2++;
            if (nums[pos3] * 5 == target)
                pos3++;
            nums[i+1] = target;
        }
        Map<Integer, String> map = new HashMap<>();

//        System.out.println(pos1);
//        System.out.println(pos2);
//        System.out.println(pos3);
        return nums[n - 1];
    }
}