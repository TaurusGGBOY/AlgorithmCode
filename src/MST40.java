import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)
            return new int[0];
        if (arr.length == 1 || arr.length == 0)
            return arr;
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        int[] temp = new int[queue.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = queue.poll();
        }
        return temp;
    }
}