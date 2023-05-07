import java.util.AbstractMap;
import java.util.PriorityQueue;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int pos = 0;
        int maxDis = 0;
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = Math.abs(nums1[i] - nums2[i]);
            if (temp > maxDis) {
                maxDis = temp;
                pos = i;
            }
            sum += temp;
        }
        if (sum == 0) {
            return 0;
        }
        int tempSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            tempSum = Math.min(Math.abs(nums1[i] - nums2[pos]), tempSum);
        }
//        System.out.println(pos+" "+tempSum);
        sum = sum - Math.abs(nums1[pos]-nums2[pos]) + tempSum;
        return (int) (sum % 1000000007);
    }
}