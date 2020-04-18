import java.util.Arrays;

class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res = new int[requirements.length];
        Arrays.fill(res, -1);
        int[][] value = new int[increase.length+1][3];
        int flag = 0;
        int startPos = 0;
        value[0][0] = 0;
        value[0][1] = 0;
        value[0][2] = 0;
        for (int i = 1; i < value.length; i++) {
            value[i][0] += value[i - 1][0] + increase[i-1][0];
            value[i][1] += value[i - 1][1] + increase[i-1][1];
            value[i][2] += value[i - 1][2] + increase[i-1][2];
        }
        int l;
        int r;
        int m;


        for (int i = 0; i < requirements.length; i++) {
//            System.out.println("第" + i);
            l = 0;
            r = value.length - 1;
            if (!isHigh(value[r], requirements[i])) {
                res[i] = -1;
                continue;
            }
            while (l < r) {
                m = (l + r) / 2;
                if (isHigh(value[m], requirements[i])) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
//
//                System.out.println(l);
//                System.out.println(m);
//                System.out.println(r);
            }
            res[i] = isHigh(value[l], requirements[i])?l:l+1;
        }
        return res;
    }

    boolean isHigh(int[] value, int[] require) {
//        System.out.println("value");
//        System.out.print(value[0]);
//        System.out.print(value[1]);
//        System.out.println(value[2]);
//        System.out.print(require[0]);
//        System.out.print(require[1]);
//        System.out.println(require[2]);
        return value[0] >= require[0] && value[1] >= require[1] && value[2] >= require[2];
    }


}