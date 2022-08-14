import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] sortArray(int[] nums) {
        myPriorityQueue queue = new myPriorityQueue();
        for (int num : nums) queue.offer(num);
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }

    class myPriorityQueue {
        List<Integer> list;

        public myPriorityQueue() {
            list = new ArrayList<>();
        }

        public int poll() {
            int res = list.get(0);
            swap(0, list.size() - 1);
            heapify(0, list.size() - 2);
            list.remove(list.size() - 1);
            return res;
        }

        public void offer(int num) {
            list.add(num);
            for (int i = (list.size() - 2) / 2; i >= 0; i=(i+1)/2-1) {
                heapify(i, list.size() - 1);
            }
        }

        void heapify(int i, int last) {
            while (2 * i + 1 <= last) {
                int l = 2 * i + 1, r = 2 * i + 2, max = i;
                if (l <= last && list.get(l) > list.get(max)) max = l;
                if (r <= last && list.get(r) > list.get(max)) max = r;
                if (max == i) break;
                swap(i, max);
                i = max;
            }
        }

        void swap(int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}