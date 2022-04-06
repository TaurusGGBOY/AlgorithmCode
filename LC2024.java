class Solution {
    String s;
    int k;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        s = answerKey;
        this.k = k;
        return Math.max(getMax('T'), getMax('F'));
    }

    int getMax(char c) {
        int res = 0;
        for (int l = 0, r = 0, change = 0, contain = 0; r < s.length(); r++) {
            contain += s.charAt(r) == c ? 1 : 0;
            change += s.charAt(r) != c ? 1 : 0;
            while (change > k) {
                contain += s.charAt(l) == c ? -1 : 0;
                change += s.charAt(l) != c ? -1 : 0;
                l++;
            }
            res = Math.max(res, contain + change);
        }
        return res;
    }
}
