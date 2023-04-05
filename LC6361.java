class Solution {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!isPrime(nums[i][i])) continue;
            res = Math.max(res, nums[i][i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isPrime(nums[i][nums[0].length - 1 - i])) continue;
            res = Math.max(res, nums[i][nums[0].length - 1 - i]);
        }
        return res;
    }

    boolean isPrime(int num) {
        if(num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}