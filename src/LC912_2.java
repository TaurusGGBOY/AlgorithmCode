import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) heapify(nums, i, nums.length);

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
        return nums;
    }

    void heapify(int[] nums, int pos, int len) {
        int largest = pos;
        if (pos * 2 < len && nums[pos * 2] > nums[largest]) largest = pos * 2;
        if (pos * 2 + 1 < len && nums[pos * 2 + 1] > nums[largest]) largest = pos * 2 + 1;
        swap(nums, pos, largest);
        if (largest != pos) heapify(nums, largest, len);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
