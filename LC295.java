import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** initialize your data structure here. */
    public MedianFinder() {
        queue1 = new PriorityQueue<Integer>(new intCmp());
        queue2 = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
       // System.out.println(queue1.toString());
        //System.out.println(queue2.toString());
        if(queue1.size()==0&&queue2.size()==0)
        {
            queue1.add(num);
            return;
        }
        if(queue1.size()==1&&queue2.size()==0)
        {
            int temp = queue1.peek();
            if(temp>num)
            {
                queue1.poll();
                queue1.add(num);
                queue2.add(temp);
            }
            else
                queue2.add(num);
            return;
        }
        if ((queue1.size() + queue2.size()) % 2 == 0){
               if(queue1.peek()>num)
                   queue1.add(num);
               else
                   queue2.add(num);
        }
        else
        {
            if(queue1.size()>queue2.size())
            {
                int temp = queue1.peek();
                if(temp>num)
                {
                    queue1.poll();
                    queue2.add(temp);
                    queue1.add(num);
                }
                else
                {
                    queue2.add(num);
                }
            }
            else
            {
                int temp = queue2.peek();
                if(temp<num)
                {
                    queue2.poll();
                    queue1.add(temp);
                    queue2.add(num);
                }
                else
                {
                    queue1.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if ((queue1.size() + queue2.size()) % 2 == 0) {
            return (queue1.peek()*1.0f+queue2.peek()*1.0f)/2;
        }
        return queue1.size() > queue2.size() ? queue1.peek() : queue2.peek();
    }

    class intCmp implements Comparator<Integer>
    {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */