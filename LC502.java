import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<List<Integer>> profitQue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) - o1.get(0);
            }
        });
        Queue<List<Integer>> capQue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        for (int i = 0; i < profits.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(profits[i]);
            list.add(capital[i]);
            capQue.offer(list);
        }

        while (k > 0) {
            while (!capQue.isEmpty() && capQue.peek().get(1) <= w) {
                profitQue.offer(capQue.poll());
            }
            if (profitQue.isEmpty()) {
                break;
            }
            w += profitQue.poll().get(0);
            k--;
        }
        return w;
    }
}