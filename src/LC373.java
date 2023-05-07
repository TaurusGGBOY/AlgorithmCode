class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) q.add(new int[]{i, 0});
        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !q.isEmpty()) {
            int[] poll = q.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[poll[0]],nums2[poll[1]])));
            if (poll[1] + 1 < nums2.length) q.add(new int[]{poll[0], poll[1] + 1});
        }
        return res;
    }
}