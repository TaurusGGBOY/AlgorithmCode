import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] bigger = new int[heights.length];
        int[] maxIndex = new int[heights.length];
        Arrays.fill(bigger, -1);

        for (int i = 0; i < maxIndex.length; i++) {
            maxIndex[i] = i;
        }


        Deque<Integer> maxStack = new ArrayDeque<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!maxStack.isEmpty() && heights[maxStack.peekLast()] <= heights[i]) {
                maxStack.pollLast();
            }

            bigger[i] = maxStack.isEmpty() ? -1 : maxStack.peekLast();

            maxStack.offerLast(i);
        }


//        System.out.println(Arrays.toString(bigger));

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int q1 = Math.min(q[0], q[1]);
            int q2 = Math.max(q[0], q[1]);

            if (q1 == q2) {
                res[i] = q2;
                continue;
            }

            if (heights[q1] < heights[q2]) {
                res[i] = q2;
                continue;
            }

            while (q2 != -1 && heights[q1] >= heights[q2]) {
                q2 = bigger[q2];
            }

            if (q2 == -1) {
                res[i] = -1;
                continue;
            }

            res[i] = q2;
        }

        return res;
    }
}