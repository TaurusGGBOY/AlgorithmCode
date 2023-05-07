class Solution {
    int ans;

    public int countMaxOrSubsets(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = maxVal | num;
        }
        ans = 0;
        dfs(nums, 0, 0, maxVal);
        dfs(nums, 0, nums[0], maxVal);
//        System.out.println();
        return ans;
    }

    void dfs(int[] nums, int pos, int temp, int maxVal) {
        if (pos >= nums.length) {
            return;
        }
//        System.out.println(pos + " " + temp + " ");
        if (temp == maxVal) {
            ans += (int) Math.pow(2, nums.length - pos-1);
            return;
        }
        dfs(nums, pos + 1, temp, maxVal);
        try {
            dfs(nums, pos + 1, temp | nums[pos + 1], maxVal);
        } catch (Exception e) {
        }
    }
}