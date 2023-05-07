class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            stringBuilder.append(strs[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }


}