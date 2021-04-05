import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] pos = new int[2];
        pos[0] = n;
        pos[1] = 0;

        for (int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }
        int temp = 0;
        while (pos[0] < m + n && pos[1] < n) {
            if (nums1[pos[0]] < nums2[pos[1]]) {
                nums1[temp++] = nums1[pos[0]++];
            } else {
                nums1[temp++] = nums2[pos[1]++];
            }
        }
        while (pos[0] < m + n) {
            nums1[temp++] = nums1[pos[0]++];
        }
        while (pos[1] < n) {
            nums1[temp++] = nums2[pos[1]++];
        }
    }
}