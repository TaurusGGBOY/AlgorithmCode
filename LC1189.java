class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        int[] alpha = new int[26];
        for (char c : chars) alpha[c - 'a']++;
        int res = Integer.MAX_VALUE;
        res = Math.min(alpha['a' - 'a'], res);
        res = Math.min(alpha['b' - 'a'], res);
        res = Math.min(alpha['l' - 'a']/2, res);
        res = Math.min(alpha['o' - 'a']/2, res);
        res = Math.min(alpha['n' - 'a'], res);
        return res;
    }
}