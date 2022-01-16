class Solution {
    public int totalMoney(int n) {
        int week = n / 7 + 1;
        int remind = n % 7;
        int sum = 0;
        for (int i = 1; i <= remind; i++) {
            sum += (i + i + week - 1) * week / 2;
        }
        for (int i = remind + 1; i <= 7; i++) {
            sum += (i + i + week - 2) * (week - 1) / 2;
        }
        return sum;
    }
}