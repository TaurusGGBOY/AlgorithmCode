import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) return fruits.length;
        int l = 0;
        int r = fruits.length - 1;
        int res = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            Set<Integer> set = new HashSet<>();
            int i = m;
            for (; i < fruits.length; i++) {
                set.add(fruits[i]);
                if (set.size() > 2) break;
            }
            if (i - m > res) {
                res = i - m;
                r = m;
            } else l = m + 1;
        }
        return res;
    }
}