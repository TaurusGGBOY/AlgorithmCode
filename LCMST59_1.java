import java.util.Arrays;
import java.util.Collection;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null)
            return null;
        if (nums.length == 0)
            return nums;
        if(nums.length==1)
            return nums;
        if(nums.length==2)
        {
            int[] temp = new int[1];
            temp[0] = Math.max(nums[0], nums[1]);
            return temp;
        }
        int len = nums.length;
        int[] newnum = new int[len + 2];
        System.arraycopy(nums, 0, newnum, 0, len);
        int length = 0;
        if (nums.length <= 2) {
            length = nums.length;
        } else {
            length = nums.length - 2;
        }

        int[] max = new int[length];
        for (int i = 0; i < length; i++) {
            max[i] = Math.max(Math.max(newnum[i], newnum[i + 1]), newnum[i + 2]);

        }
        return max;
    }
}