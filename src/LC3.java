class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, res = 0;
        int[] alpha = new int[128];
        while (r < s.length()) {
            alpha[s.charAt(r)]++;
            while (alpha[s.charAt(r)] > 1) alpha[s.charAt(l++)]--;
            res = Math.max(r++ - l + 1, res);
        }
        return res;
    }
}