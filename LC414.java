import java.util.HashSet;
import java.util.Set;

class Solution {
    public int thirdMax(int[] nums) {
        int maxNum = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            maxNum = Math.max(maxNum, num);
        }
        nums = new int[set.size()];
        int count = 0;
        for (int num : set)
            nums[count++] = num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }

            }
        }
        try {
            return nums[nums.length - 3];
        } catch (Exception e) {
            return maxNum;
        }

    }
}