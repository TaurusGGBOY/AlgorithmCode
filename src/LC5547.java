import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(isEqual(nums, l[i], r[i]));
        }
        return res;

    }
    boolean isEqual(int[] nums, int l ,int r)
    {
        int[] temp = new int[r-l+1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[l + i];
        }
        Arrays.sort(temp);
        int first = temp[0];
        int dis = temp[1]-temp[0];
        for (int i = 2; i < temp.length; i++) {
            int tDis = temp[i]-temp[i-1];
            if(tDis!=dis)
                return false;
        }
        return true;
    }
}