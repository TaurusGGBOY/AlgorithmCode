class Solution {
    public int maxScore(String s) {
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') one++;
        }
        int max = 0;
        int zero = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') one--;
            else zero++;
            max = Math.max(max, zero + one);
        }
        return max;
    }
}