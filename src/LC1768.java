class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));
        }
        if(word1.length() > len) stringBuilder.append(word1.substring(len));
        if(word2.length() > len) stringBuilder.append(word2.substring(len));
        return stringBuilder.toString();
    }
}