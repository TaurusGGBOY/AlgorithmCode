class Solution {
    public int countAsterisks(String s) {
        int status = 0;
        char[] chars = s.toCharArray();
        int res = 0;

        for (char c : chars) {
            if (c == '|') status = (status + 1) % 2;
            else if (c == '*' && status == 0) res++;
        }
        return res;
    }
}