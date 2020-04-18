import java.util.Arrays;
import java.util.Vector;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        Vector<Integer> vector = new Vector<>();
        while(i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                vector.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        int[] resArr = new int[vector.size()];
        for(int k=0;k<vector.size();k++)
            resArr[k]=vector.get(k);
        return resArr;
    }
}