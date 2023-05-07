import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        next:
        for (int i = left; i <= right; i++) {
            int n = i;
            while (n > 0) {
                int temp = n % 10;
                if (temp == 0 || i % temp != 0) continue next;
                n = n / 10;
            }
            res.add(i);
        }
        return res;
    }
}