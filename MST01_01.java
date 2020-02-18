class Solution {
    public boolean isUnique(String astr) {
        if (astr.length() <= 1) {
            return true;
        }
        if (astr.length() > 26) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            char temp = (char)('a'+i);
        }
    }
}