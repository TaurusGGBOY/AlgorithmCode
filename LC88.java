class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int l = n, r = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (r == n) return;
            if (l < nums1.length && nums1[l] <= nums2[r]) nums1[i] = nums1[l++];
            else nums1[i] = nums2[r++];
        }
    }
}