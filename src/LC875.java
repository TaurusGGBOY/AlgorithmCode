import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int min = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long sum = 0;
            for (int pile : piles) {
                sum += pile % m == 0 ? pile / m : pile / m + 1;
            }
            if (sum > h) l = m + 1;
            else {
                min = m;
                r = m - 1;
            }
        }
        return min;

    }
}