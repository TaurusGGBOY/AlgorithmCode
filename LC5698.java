class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long res = 0;
        long dis = Math.abs(goal - sum);
        if (dis % limit == 0) {
            res = dis / limit;
        } else {
            res = dis / limit + 1;
        }
        return (int)res;
    }
}