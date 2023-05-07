class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        double sqrt = Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        if (sqrt * sqrt == num) {
            sum -= sqrt;
        }
        return sum == num * 2;
    }
}