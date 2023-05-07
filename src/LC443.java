class Solution {
    public int compress(char[] chars) {
        char before = chars[0];
        int len = chars.length;
        if(len==1)
            return 1;
        int pos = 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == before) {
                count++;
            } else {
                if (count == 1) {
                    chars[pos++] = before;
                    before = chars[i];
                } else {
                    chars[pos++] = before;
                    String str = String.valueOf(count);
                    for (int j = 0; j < str.length(); j++)
                        chars[pos++] = str.charAt(j);
                    count = 1;
                    before = chars[i];
                }
            }
        }
        if (count == 1) {
            chars[pos++] = before;
        } else {
            chars[pos++] = before;
            String str = String.valueOf(count);
            for (int j = 0; j < str.length(); j++)
                chars[pos++] = str.charAt(j);
            count = 1;
        }
        return pos;

    }
}