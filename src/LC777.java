class Solution {
    public boolean canTransform(String start, String end) {
        char[] chars = start.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            char c1 = chars[i];
            char c2 = end.charAt(i);
            if(i == chars.length-1 && c1 != c2) return false;
            if(c1 == c2) continue;
            if(c1 == 'X' && chars[i+1] == 'L' && c2 == 'L' && end.charAt(i+1) =='X'){
                chars[i] = 'L';
                chars[i+1] = 'X';
            }else if(c1 == 'R' && chars[i+1] == 'X' && c2 == 'X' && end.charAt(i+1) =='R') {
                chars[i] = 'X';
                chars[i + 1] = 'R';
            }
            return false;
        }
        return true;
    }
}