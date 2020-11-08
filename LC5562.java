import java.util.*;

class Solution {
    public int minDeletions(String s) {
        int[] alphas = new int[26];
        for (char c : s.toCharArray()) {
            alphas[c - 'a']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i =0;i<alphas.length;i++) {
            char c = (char) (i + 'a');
            if (alphas[c - 'a'] != 0)
                queue.add(alphas[c - 'a']);
        }
//        System.out.println(queue.toString());
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int mark = 0;
            while (!queue.isEmpty() && queue.peek() == temp) {
                queue.poll();
                mark++;
                count++;
            }
            if (temp - 1 > 0)
                for (int i = 0; i < mark; i++) {
                    queue.add(temp - 1);
                }
        }
        return count;
    }
}