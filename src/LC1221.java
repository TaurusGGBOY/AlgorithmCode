import java.util.Queue;

class Solution {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int res = 0;
        for (char c : chars) {
            if (c == 'R') {
                count++;
            }else{
                count--;
            }
            if (count==0) {
                res++;
            }
        }
        return res;
    }
}