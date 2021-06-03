import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int[] count = new int[2];
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[num]++;
            int dis = count[0] - count[1];
            if (map.containsKey(dis)) {
                res = Math.max(res, i - map.get(dis));
            }else{
                map.put(dis, i);
            }
        }
        return res;
    }
}