import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst();
            }
        }
        if (set.size() < 3) {
            return set.pollLast();
        }else{
            return set.pollFirst();
        }

    }
}