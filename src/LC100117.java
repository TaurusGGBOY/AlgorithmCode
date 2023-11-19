class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] min = new int[nums1.length];
        int[] max = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            min[i] = Math.min(nums1[i], nums2[i]);
            max[i] = Math.max(nums1[i], nums2[i]);
        }

        int count = 0;
        for (int i = 0; i < nums1.length - 1; i++) {
            if (nums1[i] > max[nums1.length - 1] && nums2[i] > max[nums1.length - 1]) {
                return -1;
            }

            if (nums1[i] <= nums1[nums1.length - 1] && nums2[i] <= nums2[nums1.length - 1]) {
                continue;
            }

            if (nums1[i] <= nums2[nums1.length - 1] && nums2[i] <= nums1[nums1.length - 1]) {
                ++count;
                continue;
            }

            return -1;
        }

        int res = count;

        count = 1;
        int temp = nums1[nums1.length - 1];
        nums1[nums1.length - 1] = nums2[nums1.length - 1];
        nums2[nums2.length - 1] = temp;

        for (int i = 0; i < nums1.length - 1; i++) {
            if (nums1[i] > max[nums1.length - 1] && nums2[i] > max[nums1.length - 1]) {
                return -1;
            }

            if (nums1[i] <= nums1[nums1.length - 1] && nums2[i] <= nums2[nums1.length - 1]) {
                continue;
            }

            if (nums1[i] <= nums2[nums1.length - 1] && nums2[i] <= nums1[nums1.length - 1]) {
                ++count;
                continue;
            }

            return -1;
        }

        res = Math.min(count, res);

        return res;
    }
}