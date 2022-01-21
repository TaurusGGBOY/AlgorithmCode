import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, r);
    }

    void merge(int[] nums, int l, int r) {
        int m = (l + r) / 2, lp = l, rp = m + 1, n = r - l + 1, index = 0;
        int[] temp = new int[n];
        while (index < temp.length) {
            if (lp > m) {
                System.arraycopy(nums, rp, temp, index, n - index);
                break;
            }
            if (rp > r) {
                System.arraycopy(nums, lp, temp, index, n - index);
                break;
            }
            if (nums[lp] <= nums[rp]) temp[index++] = nums[lp++];
            else temp[index++] = nums[rp++];
        }
        System.arraycopy(temp, 0, nums, l, n);
    }

}