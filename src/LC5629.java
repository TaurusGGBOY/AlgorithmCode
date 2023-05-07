class Solution {
    public String reformatNumber(String number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c != '-' && c != ' ')
                stringBuilder.append(c);
        }
        int remind = stringBuilder.length();
        int pos = 0;
        StringBuilder res = new StringBuilder();
        while (remind != 0) {
            if (remind == 4) {
                res.append('-');
                res.append(stringBuilder.charAt(pos++));
                res.append(stringBuilder.charAt(pos++));
                res.append('-');
                res.append(stringBuilder.charAt(pos++));
                res.append(stringBuilder.charAt(pos++));
                remind -= 4;
                break;
            }
            if (remind == 2) {
                res.append('-');
                res.append(stringBuilder.charAt(pos++));
                res.append(stringBuilder.charAt(pos++));
                break;
            }
            if (remind == 3) {
                res.append('-');
                res.append(stringBuilder.charAt(pos++));
                res.append(stringBuilder.charAt(pos++));
                res.append(stringBuilder.charAt(pos++));
                break;
            }
            res.append('-');
            res.append(stringBuilder.charAt(pos++));
            res.append(stringBuilder.charAt(pos++));
            res.append(stringBuilder.charAt(pos++));
            remind -= 3;
        }
        if (res.toString().startsWith("-")) {
            return res.substring(1);
        }
        return res.toString();
    }
}