import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if(map.get(num)==1 && !map.containsKey(num-1)&&!map.containsKey(num+1)) res.add(num);
        }
        return res;
    }
}