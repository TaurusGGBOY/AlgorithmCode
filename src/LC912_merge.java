import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) return new int[]{nums[l]};
        if (l == r - 1) return new int[]{Math.min(nums[l], nums[r]), Math.max(nums[l], nums[r])};
        int m = (l + r) / 2;
        int[] nums1 = mergeSort(nums, l, m);
        int[] nums2 = mergeSort(nums, m + 1, r);
        int[] res = new int[r - l + 1];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < res.length; i++) {
            if (index1 < nums1.length && (index2 > nums2.length - 1 || nums1[index1] < nums2[index2]))
                res[i] = nums1[index1++];
            else res[i] = nums2[index2++];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}