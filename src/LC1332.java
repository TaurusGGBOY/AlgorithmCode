class Solution {
    public int removePalindromeSub(String s) {
        if(s.isEmpty())
            return 0;
        char[] cstr = s.toCharArray();
        int[] a = new int[2];
        for (int i = 0; i < s.length() / 2; i++) {
            char c = cstr[i];
            cstr[i] = cstr[s.length() - i - 1];
            cstr[s.length() - i - 1] = c;
        }
        if (s.equals(String.valueOf(cstr))) {
            return 1;
        }
        return 2;
    }
}