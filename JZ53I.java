class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l = 0;
        int r = nums.length - 1;
        int left = r;
        int right = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
            else {
                right = Math.max(right, m);
                l = m + 1;
            }
        }
        l = 0;
        r = right;
//        System.out.println(right);

        if (nums[right] != target) return 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
            else {
                left = Math.min(left, m);
                r = m - 1;
            }
        }
//        System.out.println(right + " " + left);
//        System.out.println();
        return right - left + 1;
    }
}