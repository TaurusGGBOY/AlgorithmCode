class Solution {
    public int[] sortArray(int[] nums) {
        build(nums);
        heapSort(nums);
        return nums;
    }

    void build(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) heapify(nums, i, nums.length - 1);
    }

    void heapSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i - 1);
        }
    }

    /***
     *
     * @param nums
     * @param i
     * @param r:右边界（包括）
     */
    void heapify(int[] nums, int i, int r) {
        int max = i;
        if (2 * i + 1 <= r && nums[max] < nums[2 * i + 1]) max = 2 * i + 1;
        if (2 * i <= r && nums[max] < nums[2 * i]) max = 2 * i;
        if (max != i) {
            swap(nums, max, i);
            heapify(nums, max, r);
        }
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}