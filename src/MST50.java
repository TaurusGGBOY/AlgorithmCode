class Solution {
    public char firstUniqChar(String s) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}