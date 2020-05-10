import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int count = 1;
        int len =0;
        for (int i = 0; i < target.length; i++) {
            while (count != target[i]&&len<target.length) {
                res.add("Push");
                res.add("Pop");
                count++;
            }
            if(count==target[i]&&len<=target.length)
            {
                res.add("Push");
                count++;
                len++;
            }
        }
        return res;
    }
}