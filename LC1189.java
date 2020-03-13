class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alpha = new int[26];
        for (int i = 0; i < text.length(); i++) {
            alpha[text.charAt(i) - 'a']++;
        }
        int times = 0;
        while (true) {
            alpha['a' - 'a']--;
            alpha['b' - 'a']--;
            alpha['l' - 'a'] -= 2;
            alpha['n' - 'a']--;
            alpha['o' - 'a'] -= 2;
            if (alpha['a' - 'a'] < 0 || alpha['b' - 'a'] < 0 || alpha['l' - 'a'] < 0 || alpha['n' - 'a'] < 0 || alpha['o' - 'a'] < 0) {
                break;
            }
            times++;
        }
        return times;
    }

}