class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int row=1;
        int score = 100;
        for (int i = 0; i < S.length(); i++) {
            if(score-widths[S.charAt(i)-'a']<0)
            {
                row++;
                score=100;
            }
            score-=widths[S.charAt(i)-'a'];
        }
        return new int[]{row,100-score};
    }

}