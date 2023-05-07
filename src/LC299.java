import java.util.HashMap;
import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        char[] sChars = secret.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        char[] gChars = guess.toCharArray();

        int cows=0;
        int bulls = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == gChars[i]) {
                bulls++;
            }else{
                map.merge(sChars[i], 1, Integer::sum);
            }
        }
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != gChars[i]) {
                if (map.containsKey(gChars[i])) {
                    int count = map.get(gChars[i]);
                    count--;
                    cows++;
                    if (count > 0) {
                        map.put(gChars[i], count);
                    }else{
                        map.remove(gChars[i]);
                    }
                }
            }
        }
        return bulls + "A" + cows + "B";

    }
}