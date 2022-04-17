class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < len; i++) {
            if (stringBuilder.toString().endsWith(goal)) return true;
            stringBuilder.append(s.charAt(i));
        }
        return false;
    }
}