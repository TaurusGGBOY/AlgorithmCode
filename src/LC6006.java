import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int i = 0; i < beans.length; i++) sum += beans[i];
        long res = sum;
        for (int i = 0; i < beans.length; i++)
            res = Math.min(sum - (long) beans[i] * (long) (beans.length - i), res);
        return res;
    }
}