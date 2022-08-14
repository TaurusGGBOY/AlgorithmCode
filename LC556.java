import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        char[] chars = s.toCharArray();
        long max = (long) Integer.MAX_VALUE + 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            char[] temp = Arrays.copyOf(chars, chars.length);
            char c = temp[i];
            int pos = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[pos] == c && temp[j] > temp[pos]) {
                    pos = j;
                    continue;
                }
                if (temp[pos] != c && temp[j] < temp[pos] && temp[j] > c) pos = j;
            }
            temp[i] = temp[pos];
            temp[pos] = c;
            Arrays.sort(temp, i + 1, temp.length);
            long num = Long.parseLong(String.valueOf(temp));
            if (num > n) {
                max = Math.min(max, num);
                break;
            }
        }
        if (max > Integer.MAX_VALUE) return -1;
        return (int) max;
    }
}