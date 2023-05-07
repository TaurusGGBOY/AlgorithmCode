import java.util.*;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        q.addAll(Arrays.asList(new int[][]{{0, a}, {1, b}, {2, c}}));
        StringBuilder stringBuilder = new StringBuilder();
        while (!q.isEmpty()) {
            int n = q.size();
            Queue<int[]> waiting = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int[] poll = q.poll();
                if (poll[1] <= 0) continue;
                if (valid(stringBuilder, (char) (poll[0] + 'a'))) {
                    stringBuilder.append((char) (poll[0] + 'a'));
                    poll[1]--;
                    waiting.offer(poll);
                    break;
                } else waiting.offer(poll);
            }
            if (waiting.size() == n) break;
            while (!waiting.isEmpty()) q.offer(waiting.poll());
        }
        return stringBuilder.toString();
    }

    boolean valid(StringBuilder stringBuilder, char c) {
        if (stringBuilder.length() < 2) return true;
        if (stringBuilder.charAt(stringBuilder.length() - 1) == stringBuilder.charAt(stringBuilder.length() - 2)
                && stringBuilder.charAt(stringBuilder.length() - 1) == c) return false;
        return true;
    }


}