import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(nums[0]);
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i =1;i<nums.length;i++)
        {
            int curr = nums[i];
            while (set.contains(curr)) {
                int poll = queue.poll();
                sum -= poll;
                set.remove(poll);
            }
            queue.add(curr);
            set.add(curr);
            sum += curr;
            max = Math.max(sum, max);
        }
        return max;
    }
}