import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        loop:
        for (int i = 0; i < l.length; i++) {
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(temp);
            int dis = temp[1] - temp[0];
            for (int j = 2; j < temp.length; j++) {
                if(temp[j] - temp[j-1] != dis){
                    res.add(false);
                    continue loop;
                }
            }
            res.add(true);
        }
        return res;
    }
}