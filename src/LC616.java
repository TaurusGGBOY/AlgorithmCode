class Solution {
    public String largestPalindromic(String num) {
        int[] alpha = new int[10];
        for (int i = 0; i < num.length(); i++) alpha[num.charAt(i) - '0']++;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = alpha.length - 1; i >= 0; i--) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                stringBuilder.append((char) (i + '0'));
            }
        }

        while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0') stringBuilder.deleteCharAt(0);
        String str = stringBuilder.toString();
        stringBuilder.reverse();

        boolean flag = false;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] % 2 == 1) {
                str = str + ((char) (i + '0'));
                flag = true;
                break;
            }
        }
        if (str.isEmpty()) return "0";
        str = str + stringBuilder.toString();

        return str;
    }
}