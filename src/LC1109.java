import java.util.Arrays;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] up = new int[n+1];
        for (int[] booking : bookings) {
            up[booking[0]-1] += booking[2];
            up[booking[1]] -= booking[2];
        }
//        System.out.println(Arrays.toString(up));
        int[] res = new int[n];
        res[0] = up[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + up[i];
        }   
        return res;
    }
}