import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int sum =0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int nowSum=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            nowSum+=nums[i];
            list.addLast(nums[i]);
            if(nowSum>sum-nowSum)
            {
                break;
            }
        }

        return list;

    }
}