class Solution {
    public String replaceDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                stringBuilder.append(s.charAt(i));
            }else{
                stringBuilder.append((char)(s.charAt(i-1) + s.charAt(i) - '0'));
            }
        }
        return stringBuilder.toString();
    }
}