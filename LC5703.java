import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Level;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dis = (o1[1]-o1[0])*1.0f/((o1[1]*o1[1]+o1[1])*1.0f)-(o2[1]-o2[0])*1.0f/((o2[1]*o2[1]+o2[1])*1.0f);
                if (dis > 0) {
                    return -1;
                } else if (dis < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int full = 0;
        for (int[] aClass : classes) {
            if(aClass[0]==aClass[1]){
                full++;
            }else{
                queue.add(aClass);
            }
        }

        while (extraStudents != 0&&!queue.isEmpty()) {
            int[] poll = queue.poll();
            poll[0]++;
            poll[1]++;
            extraStudents--;
            queue.add(poll);
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            res += (poll[0] * 1.0f) / (poll[1] * 1.0f);
        }
        res += full;
        return res / classes.length;
    }
}