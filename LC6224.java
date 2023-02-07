class Solution {
    public int subarrayGCD(int[] nums, int k) {
        boolean[] res = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = isGCD(nums[i], k);
        }
        int count = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res[i]) count++;
            else {
                ans += getNum(count);
                count = 0;
            }

        }
        ans += getNum(count);
        return ans;
    }

    int getNum(int num) {
        if(num == 0) return 0;
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    boolean isGCD(int num, int k) {
        if (num % k != 0) return false;
        if (num / k > k) return false;
        return true;
    }
}