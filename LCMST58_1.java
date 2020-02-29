class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        for (String string : str)
            string = string.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            stringBuilder.append(reverse(str[i]));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(str.length() - 1 - i));
        }
        return str.toString().trim();
    }
}