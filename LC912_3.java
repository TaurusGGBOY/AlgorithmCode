import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    private void quickSort(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[]{0, nums.length - 1});
        while (!stack.isEmpty()) {
            int[] l_r = stack.pollLast();
            int m = partition(nums, l_r[0], l_r[1]);
            if (l_r[0] < m - 1) stack.offerLast(new int[]{l_r[0], m - 1});
            if (m + 1 < l_r[1]) stack.offerLast(new int[]{m + 1, l_r[1]});
        }
    }

    int partition(int[] nums, int l, int r) {
//        randomSwap(nums, l, r);
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

    void randomSwap(int[] nums, int l, int r) {
        if(l==r) return;
        int temp = nums[l];
        int random = new Random().nextInt(r - l);
        nums[l] = nums[l + random];
        nums[l + random] = temp;
    }
}