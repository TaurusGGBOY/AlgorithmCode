

class Solution {
    public int majorityElement(int[] nums) {
        int first = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            if (first == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    first = nums[i];
                    count = 1;
                } else
                    count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += first == nums[i] ? 1 : 0;
        }
        return count > nums.length / 2 ? first : -1;
    }
}