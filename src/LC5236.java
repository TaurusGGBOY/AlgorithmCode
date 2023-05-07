class Solution {
    public int minDeletion(int[] nums) {
        int i = 0;
        int count = 0;
        for (; i < nums.length - 1; ) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                count++;
                i++;
                continue;
            }
            i = j + 1;
        }
        if ((nums.length - count) % 2 == 1) count++;
        return count;
    }
}