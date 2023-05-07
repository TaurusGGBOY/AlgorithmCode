class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if(strs[i].trim().isEmpty()) continue;
            stringBuilder.append(strs[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}