import java.util.Arrays;

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        long[] times = new long[26];
        times[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            times[keysPressed.charAt(i) - 'a'] = Math.max(times[keysPressed.charAt(i) - 'a'],releaseTimes[i] - releaseTimes[i - 1]);
        }
        long max = times[keysPressed.charAt(0)-'a'];
        char res = keysPressed.charAt(0);
        for (int i = 0; i < times.length; i++) {
            if (times[i] >= max) {
                max = times[i];
                res = (char) ('a' + i);
            }
        }
//        System.out.println(Arrays.toString(times));
        return res;
    }
}
// n 44721829