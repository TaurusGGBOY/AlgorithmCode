import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] counter = new int[n];
        counter[0] = 1;
        int step = 1;
        int pos = (0 + step * k) % n;
        while (counter[pos] == 0) {
            counter[pos] = 1;
            step++;
            pos = (pos + step * k) % n;
        }
        int num = 0;
        for (int i = 0; i < counter.length; i++) {
            num += counter[i];
        }
        num = n - num;
        int[] res = new int[num];
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) continue;
            res[index++] = i + 1;
        }
        return res;
    }
}