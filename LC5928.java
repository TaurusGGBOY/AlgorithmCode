class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() <= 1) {
            return encodedText;
        }
        int cols = encodedText.length() / rows;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = encodedText.toCharArray();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows&&i + j + j * cols<encodedText.length(); j++) {
                    stringBuilder.append(chars[i + j + j * cols]);
            }
        }
        while(stringBuilder.charAt(stringBuilder.length()-1)==' '){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}