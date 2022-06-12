class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        int[] alpha2 = new int[26];
        for (int i = 0; i < target.length(); i++) {
            alpha2[target.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < alpha.length; i++) {
            if(alpha2[i] == 0) continue;
            res = Math.min(res, alpha[i] / alpha2[i]);
        }
        return res;
    }
}