class Solution {
    public String restoreString(String s, int[] indices) {
        char[] cstr = new char[s.length()];
        for (int i=0;i<cstr.length;i++) {
            cstr[indices[i]] = s.charAt(i);
        }
        return new String(cstr);
    }
}