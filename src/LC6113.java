import java.util.*;

class SmallestInfiniteSet {

    int start;
    TreeSet<Integer> addition;

    public SmallestInfiniteSet() {
        start = 1;
        addition = new TreeSet<>();
    }

    public int popSmallest() {
        if (addition.isEmpty()) {
            return start++;
        }
        Iterator<Integer> iterator = addition.iterator();
        int first = iterator.next();
        if (first < start) {
            iterator.remove();
            return first;
        } else if (first == start) {
            iterator.remove();
        }
        return start++;
    }

    public void addBack(int num) {
        if (!addition.contains(num) && num < start) {
            addition.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */