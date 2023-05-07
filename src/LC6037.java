class Solution {
    public int largestInteger(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (((chars[i] - '0') % 2 == (chars[j] - '0') % 2) && ((chars[i] - '0') < (chars[j] - '0'))) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }
}