import java.util.Vector;

class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        String str = "aeiou";
        int max = 0;
        for (int j = 0; j < s.length() - k; j++) {
            for (int i = j; i < j + k; i++) {
                count = 0;
                char c = s.charAt(i);
                if (str.contains(String.valueOf(c)))
                    count++;
                max = Math.max(count, max);
            }

        }
        return max;
    }
}