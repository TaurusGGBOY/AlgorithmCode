class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int space = 100;
        int line = 1;
        int column = 0;
        for (int i = 0; i < s.length(); i++) {
            if (widths[s.charAt(i) - 'a'] + column > space) {
                line++;
                column = 0;
            }
            column += widths[s.charAt(i) - 'a'];
        }
        return new int[]{line, column};
    }

}