import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count =0;
        for (int i = 0; i < s.toCharArray().length/2; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        for (int i = s.toCharArray().length / 2; i < s.toCharArray().length ; i++) {
            if (set.contains(s.charAt(i))) {
                count--;
            }
        }
        return count==0?true:false;
    }
}