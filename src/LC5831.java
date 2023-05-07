import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int codeIndex;

    public long numberOfWeeks(int[] milestones) {
        if (milestones.length == 1) {
            return 1;
        }
        codeIndex = -1;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (milestones[o2] == milestones[o1]) {
                    if (codeIndex == o1) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return milestones[o2] - milestones[o1];
            }
        });
        for (int i = 0; i < milestones.length; i++) {
            queue.add(i);
        }
        long count = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() == codeIndex && queue.size() == 1) {
                break;
            }
            for (Integer integer : queue) {
                System.out.print(milestones[integer] + " ");
            }
            System.out.println();
            if (queue.peek() == codeIndex) {
                int peek = queue.poll();
                int sec = queue.poll();
                count += milestones[sec] * 2;
                milestones[peek] -= milestones[sec];
                milestones[sec] = 0;
                codeIndex = peek;
                if (milestones[peek] > 0) {
                    queue.offer(sec);
                }
            } else {
                if (queue.size() == 1) {
                    count++;
                    break;
                }
                int peek = queue.poll();
                int sec = queue.poll();
                count += milestones[sec] * 2;
                milestones[peek] -= milestones[sec];
                milestones[sec] = 0;
                codeIndex = -1;
                if (milestones[peek] > 0) {
                    queue.offer(peek);
                }
            }
        }
        return count;
    }
}