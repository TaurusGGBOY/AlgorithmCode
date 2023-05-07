import java.util.*;

class CountIntervals {

    List<Integer> list;
    Map<Integer, Integer> map;
    int count;

    public CountIntervals() {
        list = new LinkedList<>();
        map = new HashMap<>();
        count = 0;
    }

    public void add(int left, int right) {
        int index = Collections.binarySearch(list, left);
        int next = index + 1;
        int prev = index - 1;

        int prevLeft = list.get(prev);
        int prevRight = map.get(prev);
        int nextleft = list.get(next);
        int nextRight = map.get(next);
        decrese(prevLeft);
        decrese(nextleft);
        map.put(prevLeft, Math.min(left - 1, prevRight));
        map.put(left, Math.max(prevRight, right));
        map.put(nextleft, Math.max(nextRight, right));

        increase(left);
        increase(prevLeft);
    }

    public void increase(int left) {
        count += map.get(left) - left + 1;
    }

    public void decrese(int left) {
        count -= map.get(left) - left + 1;
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */