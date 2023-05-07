class Solution {
    public boolean isStraight(int[] nums) {
        int[] card = new int[13];
        int min = nums[0];
        card[nums[0]] = 1;
        for (int i = 1; i < 5; i++) {
            if (min > nums[i])
                min = nums[i];
            card[nums[i]]++;
        }
        try {
            if ((card[min] & card[min + 1] & card[min + 2] & card[min + 3] & card[min + 4]) == 1) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}