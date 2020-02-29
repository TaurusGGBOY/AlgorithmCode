class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int find = 0;
        int findSlow = slow;
        while (findSlow != find) {
            find = nums[find];
            findSlow = nums[findSlow];
        }
        return find;
    }
}