import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        int[] res = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            res[i] = start(n, startPos, chars, i);
        }

        return res;
    }

    int start(int n, int[] startPos, char[] chars, int pos) {
        int i = pos;
        int x = startPos[0];
        int y = startPos[1];
        for (; i < chars.length; i++) {
            switch (chars[i]) {
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                case 'U':
                    x--;
                    break;
                case 'D':
                    x++;
                    break;
            }
            if (!check(x, y, n)) {
                break;
            }
//            System.out.println("x"+"y"+x+" "+y);
        }
        return i - pos;
    }

    boolean check(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}