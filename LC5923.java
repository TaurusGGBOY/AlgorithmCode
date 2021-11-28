import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumBuckets(String street) {
        if (street.equals("H")||street.equals("HH")||street.equals("HHH")) {
            return -1;
        }
        if (street.contains("HHH")) {
            return -1;
        }
        if (street.startsWith("HH")) {
            return -1;
        }
        if (street.endsWith("HH")) {
            return -1;
        }
        char[] chars = street.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'H') {
                if (i == chars.length - 1) {
                    count++;
                    break;
                }
                if (chars[i + 1] != 'H') {
                    count++;
                    i+=2;
                }else{
                    count++;
                }
            }
        }
        return count;
    }

}