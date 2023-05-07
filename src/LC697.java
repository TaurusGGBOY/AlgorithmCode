// 失败
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, int[]> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            int[] orDefault = indexMap.getOrDefault(nums[i], new int[]{i, Integer.MIN_VALUE});
            orDefault[1] = i;
            indexMap.put(nums[i], orDefault);
        }
        int res = Integer.MAX_VALUE;
        int maxCount = 0;
        for (Integer integer : countMap.keySet()) {
            if (countMap.get(integer) > maxCount) {
                maxCount = countMap.get(integer);
                res = indexMap.get(integer)[1] - indexMap.get(integer)[0];
            } else if (countMap.get(integer) == maxCount) {
                res = Math.min(res, indexMap.get(integer)[1] - indexMap.get(integer)[0]);
            }
        }
        return res + 1;
    }
}