// ʧ��
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[2];
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        int lastMove = 0;
        int count = 0;
        if (len1 == 0) {

        }

        while (count++ < (len1 + len2) / 2 + 1) {
            if (pos[0] >= len1) {
                res[0] = nums2[pos[1]];
                pos[1]++;
                res[1] = nums2[pos[1]];
                lastMove = 1;
            } else if (pos[1] >= len2) {
                res[0] = nums1[pos[0]];
                pos[0]++;
                res[1] = nums1[pos[0]];
                lastMove = 0;
            } else if (nums1[pos[0]] > nums2[pos[1]]) {
                res[0] = nums2[pos[1]];
                pos[1]++;
                res[1] = nums1[pos[0]];
                lastMove = 1;
            } else {
                res[0] = nums1[pos[0]];
                pos[0]++;
                res[1] = nums2[pos[1]];
                lastMove = 0;
            }
        }

        if ((len1 + len2) % 2 == 0)
            return ((double) res[0] + (double) res[1]) / 2;
        else {
            return res[0];
        }

    }
}