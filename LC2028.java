import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int remind = mean * (n + m);
        for (int roll : rolls) remind -= roll;
        if (remind < n || remind > 6 * n) return new int[0];
        int[] res = new int[n];
        Arrays.fill(res, remind / n);
        remind -= remind / n * n;
        for (int i = 0; i < res.length; i++) {
            if (remind-- == 0) break;
            res[i]++;
        }
        return res;
    }
}