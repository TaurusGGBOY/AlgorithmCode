class Solution {
    public int minSteps(String s, String t) {
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[27];
        for (char c : s.toCharArray()) {
            alpha1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alpha2[c - 'a']++;
        }
        int res = 0 ;
        for (int i = 0; i < alpha1.length; i++) {
            res += Math.abs(alpha1[i] - alpha2[i]);
        }
        return res;
    }
}