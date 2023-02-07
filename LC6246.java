class Solution {
    public int appendCharacters(String s, String t) {
        int index = 0;
        int i = 0;
        for (; i < t.length(); i++) {
            while (index < s.length() && t.charAt(i) != s.charAt(index)) index++;
            if (index >= s.length()) break;
            index++;
        }
        return t.length() - i;

    }
}