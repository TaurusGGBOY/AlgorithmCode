class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        char[] chars = Long.toString(n).toCharArray();

        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        if (sum <= target) return 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            int in = 1;
            for (int j = chars.length - 1; j >= 0; j--) {
                if(in == 0) break;

            }
        }
    }
}