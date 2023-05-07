class Solution {
    public int majorityElement(int[] nums) {
        int prenum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                prenum = nums[i];
            } else if (nums[i] == prenum)
                count++;
            else {
                count--;
            }
        }
        return prenum;
    }
}