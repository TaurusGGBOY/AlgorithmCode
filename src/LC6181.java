class Solution {
    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int res = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] + 1 != chars[i]) {
                res = Math.max(res, i - start);
                start = i;
            }
        }
        res = Math.max(res, chars.length - start);
        return res;
    }
}