class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder stringBuilder = new StringBuilder(num);

        while(stringBuilder.charAt(stringBuilder.length()-1)=='0') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}