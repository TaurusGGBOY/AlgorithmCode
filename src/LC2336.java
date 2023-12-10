import java.util.*;

class SmallestInfiniteSet {

    TreeSet<Integer> set;
    int res;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        res = 1;
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = res;
            ++res;
            return ans;
        }

        return set.pollFirst();
    }

    public void addBack(int num) {
        if (num < res) {
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */