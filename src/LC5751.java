class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int start = i + max + 1;
            int end = nums2.length - 1;
            int mid = (start + end) / 2;
            while (start <= end) {
                if (nums1[i] <= nums2[mid]) {
                    max = mid - i;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (start + end) / 2;
            }
            if (mid < nums2.length && nums1[i] <= nums2[mid]) {
                max = mid - i;
            }
        }
        return max;
    }
}