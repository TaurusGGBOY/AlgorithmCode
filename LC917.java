class Solution {
    public String reverseOnlyLetters(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < r && !isLetter(s, l)) l++;
            while (l < r && !isLetter(s, r)) r--;
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    boolean isLetter(String s, int i) {
        return (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z');
    }
}