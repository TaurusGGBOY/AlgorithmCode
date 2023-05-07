import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int[] alpha  = new int[26];
        char[] chars1 = s.toCharArray();
        char[] chars2 = goal.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }
        int flag = 0;
        for (int i = 0; i < chars1.length; i++) {
            alpha[chars1[i]-'a']++;
            if (alpha[chars1[i] - 'a'] >= 2) {
                flag = 1;
            }
        }
        if (s.equals(goal)) {
            if (flag == 1) {
                return true;
            }else{
                return false;
            }
        }
        List<Integer> poses = new ArrayList<>();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                poses.add(i);
            }
            if (poses.size() >= 2) {
                break;
            }
        }
        if (poses.size() <= 1) {
            return false;
        }
        char temp = chars1[poses.get(0)];
        chars1[poses.get(0)] = chars1[poses.get(1)];
        chars1[poses.get(1)] = temp;
        String s1 = String.valueOf(chars1);
        String s2 = String.valueOf(chars2);

        return s1.equals(s2);
    }
}