class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isHui(word)) {
                return word;
            }
        }
        return "";
    }

    boolean isHui(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}