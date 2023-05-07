class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int[] alpha = new int[128];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (alpha[s.charAt(i)] == 1) alpha[s.charAt(l++)] = 0;
            alpha[s.charAt(i)] = 1;
            res = Math.max(i - l + 1, res);
        }
        return res;
    }
}