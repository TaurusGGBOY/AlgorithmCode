class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder stringBuilder1 = new StringBuilder(num1);
        StringBuilder stringBuilder2 = new StringBuilder(num2);
        int max = Math.max(num1.length(), num2.length());
        stringBuilder1.reverse();
        stringBuilder2.reverse();
        while (stringBuilder1.length() < max) stringBuilder1.append("0");
        while (stringBuilder2.length() < max) stringBuilder2.append("0");

        StringBuilder res = new StringBuilder();
        int in = 0;
        for (int i = 0; i < max; i++) {
            int temp = (stringBuilder1.charAt(i) - '0') * (stringBuilder2.charAt(i) - '0') + in;
            res.append((char) (temp % 10 + '0'));
            in = temp / 10;
        }
        if (in != 0) res.append((char) (in + '0'));
        return res.reverse().toString();
    }
}