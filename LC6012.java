class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            res += valid(i) ? 1 : 0;
        }
        return res;
    }

    boolean valid(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        return sum % 2 == 0;
    }
}

