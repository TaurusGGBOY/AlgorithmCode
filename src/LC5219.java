import java.util.Arrays;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) sum += candy;
        long r = sum / k, l = 1, temp = 1;
        if (r <= 1) return (int) r;
        // 强行让r变成不可能的
        while (l <= r) {
            long m = l + (r - l) / 2, res = 0;
            if (m == 0) return 0;
            for (int candy : candies) res += candy / m;
            if (res >= k) l = (temp = m) + 1;
            else r = m - 1;
        }
        return (int) temp;
    }
}