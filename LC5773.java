class Solution {
    public String maxValue(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder(n);
        char[] chars = n.toCharArray();

        if (chars[0] == '-') {
            int pos = n.length() + 1;
            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                if (c - '0' > x) {
                    pos = i;
                    break;
                }
            }
            try {
                stringBuilder.insert(pos, x);
            } catch (Exception e) {
                stringBuilder.append(x);
            }
        } else {
            int pos = n.length() + 1;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c - '0' < x) {
                    pos = i;
                    break;
                }
            }
            try {
                stringBuilder.insert(pos, x);
            } catch (Exception e) {
                stringBuilder.append(x);
            }
        }
        return stringBuilder.toString();
    }
}