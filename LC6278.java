import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int countDigits(int num) {
        List<Integer> set = new ArrayList<>();
        int n = num;
        while (n != 0) {
            set.add(n % 10);
            n /= 10;
        }
        int res = 0;
        for (int integer : set) {
            if (num % integer == 0) res++;

        }
        return res;

    }
}