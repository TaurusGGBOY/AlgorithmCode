import java.util.Arrays;

class Solution {
    public String minimizeResult(String expression) {
        String[] strs = expression.split("[+]");
        int min = Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]);
        String res = "("+expression+")";
        for (int i = 0; i < strs[0].length(); i++) {
            int num1 = 0;
            if (i != 0) num1 = Integer.parseInt(strs[0].substring(0, i));
            int num2 = Integer.parseInt(strs[0].substring(i, strs[0].length()));
            for (int j = 1; j <= strs[1].length(); j++) {
                int num3 = Integer.parseInt(strs[1].substring(0, j));
                int num4 = 0;
                if (j != strs[1].length()) num4 = Integer.parseInt(strs[1].substring(j, strs[1].length()));
                try {
                    int temp = num2 + num3;
                    if (num1 != 0) temp *= num1;
                    if (num4 != 0) temp *= num4;
                    if (temp < min) {
                        min = temp;
                        res = "(" + num2 + "+" + num3 + ")";
                        if (num1 != 0) res = num1 + res;
                        if (num4 != 0) res = res + num4;
                    }
                } catch (Exception e) {
                }
            }
        }
        return res;
    }
}