import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length - 2;
        int r = nums.length - 1;
        // 从右往左 找到一个相邻顺序对
        // 左边那个小了，所以最次也是可以和右边这个交换的
        // 交换之后，最小次序为右边所有排个序
        while (l >= 0 && nums[l] >= nums[l + 1]) l--;
        if (l < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        while (r >= l && nums[l] >= nums[r]) r--;
        swap(nums, l, r);
        reverse(nums, l + 1, nums.length - 1);
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    void reverse(int[] nums, int l, int r) {
        for (int i = 0; i < (r - l + 1) / 2; i++)
            swap(nums, l + i, r - i);
    }
}
