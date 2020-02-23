class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] sint = new int[S.length()];
        int firste = S.indexOf(C) == -1 ? S.length() - 1 : S.indexOf(C);

        for(int i=0;i<S.length();i++)
        {
            sint[i]=Math.min(Math.abs(firste-i),Math.abs(S.substring(i,S.length()).indexOf(C)-i));
            firste = S.substring(0, i).lastIndexOf(C)== -1 ? S.length() - 1 : S.indexOf(C);;
        }
        return sint;
    }
}