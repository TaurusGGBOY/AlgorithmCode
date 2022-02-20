import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int[] count1 = new int[100001];
        int[] count2 = new int[100001];
        for (int i = 0; i < nums.length; i += 2) count1[nums[i]]++;
        for (int i = 1; i < nums.length; i += 2) count2[nums[i]]++;
        Queue<int[]> q1 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Queue<int[]> q2 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != 0) q1.offer(new int[]{i, count1[i]});
        }
        for (int i = 0; i < count2.length; i++) {
            if (count2[i] != 0) q2.offer(new int[]{i, count2[i]});
        }
        int[] one1 = q1.poll();
        int[] one2 = q2.poll();
        int res = Math.min(one1[1], one2[1]);
        if (one1[0] != one2[0]) return nums.length - one1[1] - one2[1];
        if (q1.size() != 0) res = nums.length - one2[1] - q1.poll()[1];
        if (q2.size() != 0) res = Math.min(nums.length - one1[1] - q2.poll()[1], res);
        return res;
    }
}