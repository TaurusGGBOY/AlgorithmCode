import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int stone : stones) {
            queue.add(stone);
        }
        int stone1;
        int stone2;
        while(queue.size()>1)
        {
            stone1=queue.poll();
            stone2 = queue.poll();
            if(stone1!=stone2)
                queue.add(Math.abs(stone1 - stone2));
        }
        return queue.size()==1?queue.poll():0;
    }
}