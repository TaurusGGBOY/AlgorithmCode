import java.util.Arrays;
import java.util.Random;

class Solution {
    int total;
    int[] sum;

    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 0; i < sum.length - 1; i++) {
            sum[i + 1] = sum[i] + w[i + 1];
        }
        total = sum[sum.length - 1];
    }

    public int pickIndex() {
        int index = Arrays.binarySearch(sum, new Random().nextInt(total) + 1);
        return index < 0 ? -index - 1 : index;
    }
}