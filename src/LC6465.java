class Solution {
    public String smallestString(String s) {

        int start = -1;
        int end = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (start == -1 && s.charAt(i) != 'a') {
                start = i;
                end = i;
            } else if (start != -1 && s.charAt(i) != 'a') {
                end = i;
            } else if (start != -1 && s.charAt(i) == 'a') {
                break;
            }
        }
        if (start == -1) {
            start = s.length() - 1;
            end = s.length() - 1;
        }

        char[] chars = s.toCharArray();
        for (; start <= end; start++) {
            if (chars[start] != 'a') {
                chars[start] = (char) ((int) chars[start] - 1);
            } else {
                chars[start] = 'z';
            }
        }
        return new String(chars);
    }
}