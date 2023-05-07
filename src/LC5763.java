import java.util.Arrays;

class Solution {
    public boolean checkZeroOnes(String s) {
        int[] max = new int[2];
        char[] chars = s.toCharArray();
        int[] temp = new int[2];
        char before = s.charAt(0);
        max[before-'0'] = 1;
        temp[before-'0'] = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == before) {
                temp[c - '0']++;
            } else {
                temp[before - '0'] = 0;
                temp[c - '0'] = 1;
                before = c;
            }
            max[c - '0'] = Math.max(temp[c - '0'], max[c - '0']);
        }
        System.out.println(Arrays.toString(max));
        return max[1] > max[0];
    }
}