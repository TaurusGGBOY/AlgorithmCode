import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (queue1.size() != queue2.size()) {
            queue1.add(num);
            queue2.add(queue1.poll());
        } else {
            queue2.add(num);
            queue1.add(queue2.poll());
        }
    }

    public double findMedian() {
        if (queue1.size() == queue2.size()) {
            return (queue1.peek() * 1.0 + queue2.peek() * 1.0) / 2;
        }
        return queue1.size() > queue2.size() ? queue1.peek() : queue2.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */