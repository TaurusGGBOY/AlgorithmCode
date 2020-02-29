import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** initialize your data structure here. */
    public MedianFinder() {
        queue1 = new PriorityQueue<Integer>();
        queue2 = new PriorityQueue<Integer>(new intCmp());
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        if ((queue1.size() + queue2.size()) % 2 == 0) {
            return (queue1.peek()*1.0f+queue2.peek()*1.0f)/2;
        }
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