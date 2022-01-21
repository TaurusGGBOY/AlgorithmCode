import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        random(nums, l, r);
        int m = partition(nums, l, r);
        quickSort(nums, l, m - 1);
        quickSort(nums, m + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    void random(int[] nums, int l, int r) {
        int ran = l + new Random().nextInt(r - l);
        int temp = nums[l];
        nums[l] = nums[ran];
        nums[ran] = temp;
    }


}