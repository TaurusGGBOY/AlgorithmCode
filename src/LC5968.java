class Solution {
    public int numberOfBeams(String[] bank) {
        int last = 0;
        int res = 0;
        for (int i = 0; i < bank.length; i++) {
            int bit = bitCount(bank[i]);
            if (bit == 0 && i != 0) {
                continue;
            }
            res += bit * last;
            last = bit;
        }
        return res;
    }

    int bitCount(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                res++;
            }
        }
        return res;
    }
}