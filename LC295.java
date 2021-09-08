import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** initialize your data structure here. */
    public MedianFinder() {
        queue1 = new PriorityQueue<>(Comparator.reverseOrder());
        queue2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (queue1.size() == queue2.size()) {
            queue2.offer(num);
            queue1.offer(queue2.poll());
        }else{
            queue1.offer(num);
            queue2.offer(queue1.poll());
        }
    }

    public double findMedian() {
        if (queue1.size() == queue2.size()) {
            return ((queue1.peek() + queue2.peek()) * 1.0f) / 2;
        }else{
            return queue1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */