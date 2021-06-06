class Solution {
    public int minFlips(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char c = '0';
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(c);
            if (c == '0') {
                c = '1';
            }else{
                c = '0';
            }
        }
        String[] strs = new String[2];
        strs[0] = stringBuilder.toString();
        char temp = stringBuilder.charAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(0);
        if (temp == '0') {
            stringBuilder.append('1');
        }else{
            stringBuilder.append('0');
        }
        strs[1] = stringBuilder.toString();

    }
}