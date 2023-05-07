import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:arr)
            map.merge(num, 1, (newval, oldval) -> newval + oldval);
        int maxNum = -1;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getKey()==entry.getValue())
                maxNum = Math.max(maxNum, entry.getKey());
        }
        return maxNum;
    }
}