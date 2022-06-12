class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = Math.min(brackets[0][0], income) * brackets[0][1] * 1.0f / 100;

        for (int i = 1; i < brackets.length; i++) {
            if (income <= brackets[i - 1][0]) break;
            res += (Math.min(brackets[i][0], income) - brackets[i - 1][0]) * brackets[i][1] * 1.0f / 100;
        }
        return res;
    }
}