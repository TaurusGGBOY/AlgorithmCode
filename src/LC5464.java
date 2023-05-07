import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        Queue<Integer> queue = new LinkedList<>();
        int count =0;
        for(int i=0;i<numBottles;i++)
        {
            queue.add(1);
        }
        while(!queue.isEmpty())
        {
            for(int i =0;i<numExchange;i++)
            {
                try {
                    count+=queue.poll();
                }
                catch (Exception e)
                {
                    return count;
                }

            }
            queue.add(1);
        }
        return count;
    }
}