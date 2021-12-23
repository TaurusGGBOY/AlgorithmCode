// TODO fail
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public String longestDupSubstring(String s) {
        int l = 0;
        int r = s.length() - 1;
        int P = 131313;
        long[] h = new long[s.length() + 3];
        long[] p = new long[s.length() + 3];
        for (int i = 0; i < h.length; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        while (l <= r) {
            int m = (l + r) / 2;
//            System.out.println(m);
            Set<Long> set = new HashSet<>();
            boolean contain = false;
            for (int i = 0; i < s.length() - m + 1; i++) {
                int j = i+m-1;
                long cur = h[j] - h[i - 1] * p[j - i + 1];
                String str = s.substring(i, m);
                if (set.contains(cur)) {
                    contain = true;
                    queue.offer(str);
                    if (queue.size() > 1) {
                        queue.poll();
                    }
                } else {
                    set.add(cur);
                }
            }
            if (contain) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
//        System.out.println(queue.toString());
//        System.out.println();
        return queue.isEmpty() ? "" : queue.poll();
    }
}  