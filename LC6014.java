import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alpha = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) alpha[c - 'a']++;
        Queue<int[]> q = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
        for (int i = 0; i < alpha.length; i++) if (alpha[i] != 0) q.offer(new int[]{i, alpha[i]});
        StringBuilder stringBuilder = new StringBuilder();
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int start = stringBuilder.length() - 1;
            while (stringBuilder.length() > 0 && start >= 0 && stringBuilder.charAt(start) - 'a' == poll[0]) start--;
            int count = Math.min(repeatLimit - (stringBuilder.length() - start - 1), poll[1]);
            if (q.isEmpty() && count == 0) break;
            for (int i = 0; i < count; i++) stringBuilder.append((char) (poll[0] + 'a'));
            if (q.size() > 0) {
                int[] poll2 = q.poll();
                stringBuilder.append((char) (poll2[0] + 'a'));
                if (--poll2[1] > 0) q.offer(poll2);
            }
            poll[1] -= count;
            if (poll[1] > 0) q.offer(poll);
        }
        return stringBuilder.toString();
    }
}