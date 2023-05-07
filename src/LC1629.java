import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] time = new int[26];
        for (int i = 0; i < releaseTimes.length; i++)
            time[keysPressed.charAt(i) - 'a'] = Math.max(time[keysPressed.charAt(i) - 'a'],releaseTimes[i] - (i <= 0 ? 0 : releaseTimes[i - 1]));
        int max = time.length - 1;
        for (int i = time.length - 1; i >= 0; i--)
            if (time[i] > time[max]) max = i;
        return (char) (max + 'a');
    }
}