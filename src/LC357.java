class Solution {
    boolean[] nums;
    int count;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10, remind = 9;
        for (int i = 0; i < n - 1; i++) {
            remind *= 9 - i;
            res += remind;
        }
        return res;
    }

}