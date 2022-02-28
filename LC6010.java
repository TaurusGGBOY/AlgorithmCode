import java.util.Arrays;

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long r = 100000000000000L+1L;
        while (l < r) {
            long m = (l + r) / 2;
            if (check(time, totalTrips, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean check(int[] time, int totalTrips, long res) {
        long temp = 0;
        for (int i : time) {
            temp += res / i;
        }
        return temp >= totalTrips;
    }

}