import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int more = 0;
        int less= 0;
        for(int num:nums)
        {
            if(set.contains(num))
            {
                more =num;
            }
            else
            {
                set.add(num);
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(i+1))
                less=i+1;
        }
        return new int[]{more,less};
    }
}