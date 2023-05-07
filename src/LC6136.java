import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public int arithmeticTriplets(int[] nums, int diff) {
    Set<Integer> set = new HashSet<>();
    Arrays.sort(nums);
    for (int num : nums) {
      set.add(num);
    }
    int res =0;
    for (int i = 0; i < nums.length; i++) {
        int temp = nums[i] + diff;
        if(set.contains(temp) && set.contains(temp+diff)) res++;
    }
    return res;
  }
}