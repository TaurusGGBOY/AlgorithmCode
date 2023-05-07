class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zeroLen = 0;
        int oneLen = 0;
        if (s.charAt(0) == '0') zeroLen++;
        else oneLen++;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '1') zeroLen = 0;
                zeroLen++;
            } else {
                if (s.charAt(i - 1) == '0') oneLen = 0;
                oneLen++;
                res = Math.max(res, Math.min(zeroLen, oneLen) * 2);
            }
        }
        return res;
    }
}