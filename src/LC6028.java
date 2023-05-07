import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countCollisions(String directions) {
        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);
            if (c == 'S') {
                stack.offerLast(c);
            } else if (c == 'R') {
                stack.offerLast(c);
            } else if (c == 'L') {
                if (stack.isEmpty()) {
                    continue;
                } else if (stack.peekLast() == 'S') {
                    cnt++;
                } else if (stack.peekLast() == 'R') {
                    cnt += 2;
                    stack.pollLast();
                    stack.offerLast('S');
                }
            }
        }
        boolean flag = false;
        while (!stack.isEmpty()) {
            char c = stack.pollLast();
            if (c == 'S') {
                flag = true;
            }else{
                if(flag) cnt++;
            }
        }
        return cnt;
    }
}