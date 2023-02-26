import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] counter = new int[101];
        int[] res = new int[2];
        for (int num : nums) {
            if(counter[num] == 1){
                res[0]++;
                res[1]--;
                counter[num] = 0;
            }else{
                counter[num]++;
                res[1]++;
            }
        }

        return res;
    }
}