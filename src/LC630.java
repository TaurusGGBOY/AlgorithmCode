import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // 贪心策略：按照结束时间升序，按顺序学，如果超时，就弹出已经学了的里面的时间最长的课（最小代价，性价比最高）（多个怎么说？）
        // 弹栈俩可能，一个是自己是最大的，把自己弹了，之前的还是合法的，一个是弹了个其他的最大的老哥，也就是说 肯定满足上一次的最晚时间了，那肯定也满足这一次的最晚时间
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int curr = 0;
        for (int[] cours : courses) {
            curr += cours[0];
            queue.offer(cours[0]);
            if (curr > cours[1]) {
                curr -= queue.poll();
            }
        }
        return queue.size();
    }
}