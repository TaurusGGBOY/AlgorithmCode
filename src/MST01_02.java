class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] s1a = get(s1);
        int[] s2a = get(s2);
        for (int i = 0; i < 26; i++) {
            if (s1a[i] != s2a[i])
                return false;
        }
        return true;
    }

    int[] get(String s) {
        char[] ca = s.toCharArray();
        int[] a = new int[26];
        for (int i = 0; i < ca.length; i++) {
            a[ca[i] - 'a']++;
        }
        return a;
    }
}