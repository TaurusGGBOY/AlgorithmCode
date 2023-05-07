import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= 31; i++) {
            char[] chars = String.valueOf((int) Math.pow(2, i)).toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            set.add(s);
        }
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        String dst = new String(chars);
        return set.contains(dst);
    }
}