class Solution {
    public int myAtoi(String s) {
        if (s.trim().isEmpty()) return 0;
        int i = 0, neg = 1;
        while (s.charAt(i) == ' ') i++;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') neg = s.charAt(i++) == '-' ? -1 : 1;
        long res = 0;
        for (; i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++) {
            res = res * 10 + s.charAt(i) - '0';
            if (neg * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (neg * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (neg * res);
    }
}