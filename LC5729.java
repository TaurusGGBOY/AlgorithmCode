import java.util.*;

class MKAverage {
    PriorityQueue<Integer> minK;
    PriorityQueue<Integer> maxK;
    int minKSum;
    int maxKSum;
    int sum;
    int m;
    int k;
    List<Integer> list;

    public MKAverage(int m, int k) {
        minK = new PriorityQueue<>(k, Collections.reverseOrder());
        maxK = new PriorityQueue<>(k);
        minKSum = 0;
        maxKSum = 0;
        sum = 0;
        this.m = m;
        this.k = k;
        Integer integer = new Integer();
        list = new ArrayList<>();
    }

    public void addElement(int num) {
        sum += num;
        list.add(num);
        try {
            int temp = list.get(list.size() - 1 - m);
            if (maxK.contains(temp)) {
                maxK.remove(temp);
                maxKSum -= temp;
            } else if (minK.contains(temp)) {
                minK.remove(temp);
                minKSum -= temp;
            }
            sum -= temp;
        } catch (Exception e) {
        }
        if (minK.size() < k) {
            minK.offer(num);
            minKSum += num;
        } else if (maxK.size() < k) {
            maxK.offer(num);
            maxKSum += num;
        } else if (minK.peek() > num) {
            minKSum -= minK.poll();
            minK.offer(num);
            minKSum += num;
        } else if (maxK.peek() < num) {
            maxKSum -= maxK.poll();
            maxK.offer(num);
            maxKSum += num;
        }
    }

    public int calculateMKAverage() {
        if (list.size() < m) {
            return -1;
        }
        return (sum - maxKSum - minKSum) / (m - 2 * k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */