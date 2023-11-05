import java.util.List;
import java.util.Objects;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long sum = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            long res = 0;
            int temp = maxHeights.get(i);
            for (int j = i - 1; j >= 0; j--) {
                temp = Math.min(temp, maxHeights.get(j));
                res += temp;
//                System.out.print(temp + " ");
            }
            temp = maxHeights.get(i);
            for (int j = i; j < maxHeights.size(); j++) {
                temp = Math.min(temp, maxHeights.get(j));
                res += temp;
//                System.out.print(temp + " ");
            }
            sum = Math.max(res, sum);
        }
//        System.out.println();

        return sum;
    }
}