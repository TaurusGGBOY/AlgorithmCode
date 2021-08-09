import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int minSwaps(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int res = 0;
        int count = 0;
        int highest = chars.length - 1;
        int j = highest;
        for (int i = 0; i < j; i++) {
            if (chars[i] == ']') {
                if (count <= 0) {
                    for (; j > i; j--) {
                        if (chars[j] == '[') {
                            chars[j] = ']';
                            count++;
                            res++;
                            break;
                        }
                    }
                }else{
                    count--;
                }
            } else {
                count++;
            }
        }
        return res;
    }
}