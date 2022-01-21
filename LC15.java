import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int m = 1;
        while (m < nums.length - 1) {
            int l = m - 1;
            int r = m + 1;
            m++;
            while (m < nums.length - 1 && nums[m] == nums[m - 1]) m++;
        }
    }
}