import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length;
        int mid = (left + right) / 2;
//        System.out.println("s:"+s);
        while (left < right) {
            if (isChild(s, p, removable, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (isChild(s, p, removable, mid)) {
            return mid;
        }
        return mid - 1;
    }

    boolean isChild(String s, String p, int[] removable, int pos) {
        int[] flag = new int[s.length()];
        for (int i = 0; i < pos; i++) {
            flag[removable[i]] = 1;
        }
        int ppos = 0;
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i] == 0 && schars[i] == pchars[ppos]) {
                ppos++;
                if (ppos >= p.length()) {
//                    System.out.println("pos: is child:"+pos);
                    return true;
                }
            }
        }
        return false;
    }
}