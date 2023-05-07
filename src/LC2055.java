import java.util.Arrays;

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[][] leftRight = new int[2][s.length()];
        int candleIndex = Integer.MAX_VALUE;
        int count = 0;
        // 从右到左最近candle
        // 从右到左盘子数量
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                count++;
                leftRight[0][i] = candleIndex;
            } else {
                leftRight[0][i] = count;
                candleIndex = i;
            }
        }
        candleIndex = Integer.MIN_VALUE;
        count = 0;
        // 从左到右最近candle
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
                leftRight[1][i] = candleIndex;
            } else {
                candleIndex = i;
            }
        }
//        System.out.println(Arrays.toString(leftRight[0]));
//        System.out.println(Arrays.toString(leftRight[1]));

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            if ((s.charAt(q[1]) != '|' && leftRight[1][q[1]] < q[0]) || (s.charAt(q[0]) != '|' && leftRight[0][q[0]] > q[1])) {
                res[i] = 0;
                continue;
            }
            int l = s.charAt(q[0]) == '|' ? leftRight[0][q[0]] : leftRight[0][leftRight[0][q[0]]];
            int r = s.charAt(q[1]) == '|' ? leftRight[0][q[1]] : leftRight[0][leftRight[1][q[1]]];
//            System.out.println(l + " " + r + " " + leftRight[0][q[0]] + " " + leftRight[1][q[1]] + " " + leftRight[0][q[1]] + " " + leftRight[1][q[0]]);
            res[i] = l - r;
        }
        return res;
    }
}
//[2, 2, 5, 5, 5, 3, 9, 9, 9, 0]
//[-2147483648, -2147483648, 0, 2, 2, 0, 5, 5, 5, 0]
//3 2 5 0 3 0
//5 2 3 0 0 0
//[3, 3, 3, 12, 6, 6, 10, 12, 12, 12, 12, 12, 5, 15, 15, 3, 3, 19, 19, 1, 2147483647]
//[-2147483648, -2147483648, -2147483648, 0, 3, 3, 0, 6, 6, 6, 6, 6, 0, 12, 12, 0, 0, 16, 16, 0, 19]
//12 3 3 16 19 -2147483648
//10 12 6 3 6 3
//3 3 15 16 19 12
//6 12 6 6 12 3
//12 3 3 0 3 0