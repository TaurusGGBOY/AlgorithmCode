import java.util.*;

class Solution {
    int max;

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (fruits.length == 1) {
            if (fruits[0][0] >= startPos - k && fruits[0][0] <= startPos + k) {
                return fruits[0][1];
            }else{
                return 0;
            }
        }


        int[] left = new int[2*100000+3];

        Map<Integer, Integer> value = new HashMap<>();
        for (int[] fruit : fruits) {
            value.put(fruit[0], fruit[1]);
        }
        if (k == 0) {
            return value.getOrDefault(startPos, 0);
        }
        left[0] = value.getOrDefault(0, 0);
        for (int i = 1; i < left.length; i++) {
            left[i] += value.getOrDefault(i, 0) + left[i - 1];
        }
        int res = 0;
        for (int i = 1; startPos - i >= 0 && i <= k; i++) {
            int temp = 0;
            temp += left[startPos] - left[startPos - i] - value.getOrDefault(startPos, 0)+value.getOrDefault(startPos - i, 0);
            int remind = k - 2 * i;
//            System.out.println(remind);
            if (remind > 0) {
                int r = Math.min(remind + startPos, left.length - 1);
                temp += left[r] - left[startPos];
//                System.out.println("plus "+temp);
            }
            temp += value.getOrDefault(startPos, 0);
            res = Math.max(res, temp);
//            System.out.println("left" + " " + i + " " + res);
        }

        for (int i = 1; startPos + i < left.length && i <= k; i++) {
            int temp = 0;
            temp += left[startPos + i] - left[startPos];
            int remind = k - 2 * i;
//            System.out.println(remind);
            if (remind > 0) {
                int l = Math.max(startPos - remind, 0);
                temp += left[startPos] - left[l] - value.getOrDefault(startPos, 0) + value.getOrDefault(l, 0);
//                System.out.println("plus "+temp);
            }
            temp += value.getOrDefault(startPos, 0);
            res = Math.max(res, temp);
//            System.out.println("right" + " " + i + " " + res);
        }
//        System.out.println();
        return res;
    }
}
