import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.offerLast(nums[i]);
                continue;
            }
            int next = nums[i];
            while (!deque.isEmpty()) {
                int g = gcd(Math.max(deque.peekLast(), next), Math.min(deque.peekLast(), next));
//                System.out.println(deque.peekLast() + " " + next + " " + g);
                if (g == 1) {
                    deque.offerLast(next);
                    break;
                }
                int poll = deque.pollLast();
                deque.offerLast(g * (poll / g) * (next / g));
                if (deque.size() == 1) break;
                next = deque.pollLast();
            }

        }
        List<Integer> res = new ArrayList<>(deque);
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

//13
//13 121
//13 121