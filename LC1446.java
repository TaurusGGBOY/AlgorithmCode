class Solution {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int res = 1;
        int max = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]==c)
            {
                res++;
                max = Math.max(res, max);
            }
            else {
                res=1;
                c = chars[i];
            }
        }
        return max;
    }
}