class Solution {
    public int maxProduct(String[] words) {
        int[] alpha = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                alpha[i] |= 1 << (chars[j] - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < alpha.length; i++) {
            for (int j = i + 1; j < alpha.length; j++) {
                if ((alpha[i] & alpha[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}