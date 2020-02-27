import static java.lang.System.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] sint = new int[S.length()];
        int firste;
        int laste;
        for(int i=0;i<S.length();i++)
        {
            firste = S.substring(0, i).lastIndexOf(C)== -1 ? Integer.MAX_VALUE : S.substring(0, i).lastIndexOf(C);
            laste = S.substring(i,S.length()).indexOf(C)==-1?Integer.MAX_VALUE:S.substring(i,S.length()).indexOf(C);
            sint[i]=Math.min(Math.abs(firste-i),Math.abs(laste));
        }
        return sint;
    }
}