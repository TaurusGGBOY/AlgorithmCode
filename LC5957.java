class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count < spaces.length && spaces[count] == i) {
                stringBuilder.append(" ");
                count++;
            }
            stringBuilder.append(chars[i]);
        }
        if (count < spaces.length) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}