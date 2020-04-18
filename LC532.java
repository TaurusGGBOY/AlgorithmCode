import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0)
            return 0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
        {
            map.merge(num,1,(oldval,newval)->oldval+newval);
        }
        if(k==0)
        {
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
                count+=entry.getValue()>=2?1:0;
            return count;
        }
        int[] arr = new int[map.size()];
        int i=0;
        for(int num:map.keySet())
            arr[i++] = num;

        for(int num:arr)
            count+=map.keySet().contains(num+k)?1:0;
        return count;

    }
}