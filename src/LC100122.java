class Solution {
    public long minimumSteps(String s) {
        int i = 0;
        long res = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '0') {
                res += j - i;
                ++i;
            }
        }

        return res;
    }
}