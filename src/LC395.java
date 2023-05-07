class Solution {
    public int longestSubstring(String s, int k) {
        int start = 0;
        int end = 1;
        int[] alpha = new int[26];
        alpha[s.charAt(0) - 'a']++;
        int max = 1;
        while (end < s.length()) {
            alpha[s.charAt(end)-'a']++;
            if(alpha[s.charAt(end)-'a'])
            end++;

        }
    }
}