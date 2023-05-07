import java.util.*;

class Solution {
    Vector<Integer> vector;

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        vector = new Vector<>();
        LinkedList<ListIterator<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < nums.size(); i++) {
            queue.addFirst(nums.get(i).listIterator());
            map(queue);
        }
        while (!queue.isEmpty()) {
            map(queue);
        }
        int[] res = new int[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            res[i] = vector.get(i);
        }
        return res;
    }

    void map(LinkedList<ListIterator<Integer>> queue) {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            ListIterator<Integer> iterator = queue.poll();
            vector.add(iterator.next());
            if (iterator.hasNext()) {
                queue.add(iterator);
            }
        }
    }

}