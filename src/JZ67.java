class Solution {
    public int strToInt(String str) {
        if (str.trim().isEmpty()) return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != ' ') break;
        }
        int neg = 1;
        if (chars[i] == '-') neg = -1;
        if(chars[i] == '-' || chars[i] =='+') i++;
        long res = 0;
        for (; i < chars.length; i++) {
            if(chars[i] >'9' || chars[i] <'0'){
                break;
            }
            res *= 10;
            res += chars[i] - '0';
            if(neg * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(neg * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return (int) (neg * res);
    }
}