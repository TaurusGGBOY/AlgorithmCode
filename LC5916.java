import java.util.*;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int depth = 0;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int poll = queue.poll();
                for (int j = 0; j < nums.length; j++) {
                    for (int k = 0; k < 3; k++) {
                        int temp;
                        if (k == 0) {
                            temp = poll + nums[j];
                        } else if (k == 1) {
                            temp = poll - nums[j];
                        }else{
                            temp = poll ^ nums[j];
                        }
                        if (temp == goal) {
                            return depth + 1;
                        }
                        if (temp >= 0 && temp <= 1000 && !set.contains(temp)) {
                            queue.offer(temp);
                        }
                        set.add(temp);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}