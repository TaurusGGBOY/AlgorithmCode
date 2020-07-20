import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,nums.length); i++)
        {
            String s = Integer.toBinaryString(i);
            List<Integer> list = new ArrayList<>();
            int index = nums.length - s.length();
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='1')
                {
                    list.add(nums[j + index]);
                }
            }
            res.add(list);
        }
        return res;
    }
}