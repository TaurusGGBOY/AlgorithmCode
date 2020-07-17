// 失败
class Solution {
    StringBuilder stringBuilder = new StringBuilder();
    public String longestDiverseString(int a, int b, int c) {
        int counta=0;
        int countb=0;
        int countc=0;
        bfs(a,b,c,counta,countb,countc);
        return stringBuilder.toString();
    }

    public void bfs( int a, int b, int c,int counta,int countb,int countc) {
        if(counta==3||countb==3||countc==3)
            return;
        if(a<0||b <0||c<0)
            return;
        stringBuilder.append('a');
        bfs(a-1,b,c,counta,countb,countc);
        stringBuilder.deleteCharAt(stringBuilder.)
    }
}