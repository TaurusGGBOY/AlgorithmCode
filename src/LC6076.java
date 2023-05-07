import java.util.Arrays;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length <= 1) return 0;
        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);
        long[] temp1 = calcu(stockPrices[0], stockPrices[1]);
        int res = 1;
        for (int i = 1; i < stockPrices.length - 1; i++) {
            long[] temp2 = calcu(stockPrices[i], stockPrices[i + 1]);
            if (temp1[0] == temp2[0] && temp1[1] == temp2[1]) {
                continue;
            }
            res++;
            temp1 = temp2;
        }
        return res;

    }

    long[] calcu(int[] temp1, int[] temp2) {
        long[] res = new long[2];
        res[1] = temp2[1] - temp1[1];
        res[0] = temp2[0] - temp1[0];
        int neg = 1;
        if (res[1] <0) neg =-1;
        long gcd = gcd(Math.abs(res[1]), Math.abs(res[0]));
        res[1] /= gcd;
        res[0] /= gcd;
        return res;
    }

    public long gcd(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}