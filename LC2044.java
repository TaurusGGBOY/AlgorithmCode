class Solution {
    int max;
    int count;

    public int countMaxOrSubsets(int[] nums) {
        max = 0;
        count = 0;
        dfs(nums, 0, false, 0);
        dfs(nums, 0, true, 0);
        return count;
    }

    void dfs(int[] nums, int pos, boolean contain, int sum) {
        if (pos >= nums.length) return;
        if (contain) sum |= nums[pos];
        if (sum > max) {
            max = sum;
            count = 0;
        }
        if (sum == max && contain) count++;
        dfs(nums, pos + 1, false, sum);
        dfs(nums, pos + 1, true, sum);
    }
}