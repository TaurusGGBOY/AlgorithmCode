class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] count = new int[s.length()];
        int temp = 0, res = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            count[i] = temp;
            temp += s.charAt(i) == '0' ? 1 : 0;
        }
        temp = 0;
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(temp + count[i], res);
            temp += s.charAt(i) == '1' ? 1 : 0;
        }
        return res;
    }
}