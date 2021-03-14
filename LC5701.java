class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for (int i = 0; i < s1.toCharArray().length; i++) {
            alpha1[s1.charAt(i)-'a']++;
            alpha2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < alpha1.length; i++) {
            if (alpha1[i] != alpha2[i]) {
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < s1.toCharArray().length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 2;
    }
}