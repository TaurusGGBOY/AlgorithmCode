class Solution {
    public int myAtoi(String s) {
        if (s.trim().isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while (chars[i] == ' ') i++;
        int neg = 1;
        if (chars[i] == '-') neg = -1;
        if (chars[i] == '+' || chars[i] == '-') i++;
        long sum = 0;
        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            sum = sum * 10 + chars[i] - '0';
            if (sum * neg > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sum * neg < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (sum * neg);
    }
}