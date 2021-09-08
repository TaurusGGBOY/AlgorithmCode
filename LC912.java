class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }

    int partition(int[] nums, int l, int r) {
        int addition = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= addition) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l] <= addition) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
            }
        }
        nums[l] = addition;
        return l;
    }
}