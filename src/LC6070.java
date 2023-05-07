class Solution {
    public String digitSum(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder(s);

        while (s.length() > k) {
            int num = 0;
            int temp = 0;
            int len = s.length();
            for (int i = 0; i < len; i++, num++) {
                if (num == k) {
                    num = 0;
                    stringBuilder.append(temp);
                    temp = stringBuilder.charAt(i) - '0';
                } else {
                    temp += stringBuilder.charAt(i) - '0';
                }
            }
            stringBuilder.append(temp);
            stringBuilder.delete(0, len);
            s = stringBuilder.toString();
        }
        return s;
    }
}