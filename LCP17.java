class Solution {
    static int x;
    static int y;

    public int calculate(String s) {
        x = 1;
        y = 0;
        for (char c : s.toCharArray()) {
            if(c=='A')
                x=2*x+y;
            else
                y=2*y+x;
        }
        return x+y;
    }
}