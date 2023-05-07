class Solution {
    public String truncateSentence(String s, int k) {
        String[] strs = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(strs[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}