class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            char c = c1[i];
            for (int j = i; j < c1.length; j++) {
                c1[i] = c1[j];
                c1[j] = c;
                if (equal(c1, c2)) return true;
                c1[j] = c1[i];
                c1[i] = c;
            }
        }
        return false;

    }

    boolean equal(char[] c1, char[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}