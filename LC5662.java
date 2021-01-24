import java.util.Arrays;

class Solution {
    public int minCharacters(String a, String b) {
        int res = Integer.MAX_VALUE;
        int[][] alpha = new int[2][26];
        // 方案3
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (char c : charsA) {
            alpha[0][c - 'a']++;
        }
        for (char c : charsB) {
            alpha[1][c - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < alpha[0].length; i++) {
            max = Math.max(max, alpha[0][i] + alpha[1][i]);
        }
        res = Math.min(a.length() + b.length() - max, res);
        res = Math.min(compare(a, b), res);
        res = Math.min(compare(b, a), res);
        return res;
    }

    int compare(String a, String b) {
        int count = Integer.MAX_VALUE;

        int[][] alpha = new int[2][26];
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int sum1 = 0;
        int sum2 = 0;
        for (char c : charsA) {
            alpha[0][c - 'a']++;
            sum1++;
        }
        for (char c : charsB) {
            alpha[1][c - 'a']++;
            sum2++;
        }
        // 从左到右 从右到左
        int[][][] totalChange = new int[2][2][26];
        totalChange[0][0][0] = alpha[0][0];
        totalChange[0][1][25] = alpha[0][25];
        totalChange[1][0][0] = alpha[1][0];
        totalChange[1][1][25] = alpha[1][25];

        for (int i = 1; i < 25; i++) {
            totalChange[0][0][i] = totalChange[0][0][i - 1] + alpha[0][i];
            totalChange[0][1][i] = sum1 - totalChange[0][0][i - 1];
            totalChange[1][0][i] = totalChange[1][0][i - 1] + alpha[1][i];
            totalChange[1][1][i] = sum2 - totalChange[1][0][i - 1];
        }
//        System.out.println(Arrays.toString(totalChange[0][0]));
//        System.out.println(Arrays.toString(totalChange[1][1]));
        for (int i = 1; i < 25; i++) {
            count = Math.min(count, totalChange[0][0][i - 1] + totalChange[1][1][i + 1]+Math.min(alpha[0][i],alpha[1][i]));
        }
        return count;
    }
}