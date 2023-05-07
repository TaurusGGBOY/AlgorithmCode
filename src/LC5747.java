
import java.math.BigInteger;

class Solution {
    public boolean splitString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i <= chars.length; i++) {
            BigInteger last = new BigInteger(s.substring(0, i));
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                stringBuilder.append(chars[j]);
                BigInteger l = new BigInteger(stringBuilder.toString());
                if (l.equals(new BigInteger(last.toString()).add(new BigInteger("-1")))) {
                    last = last.add(new BigInteger("-1"));
                    stringBuilder.setLength(0);
                    if (j == chars.length - 1) {
                        return true;
                    } else if (last.equals(BigInteger.ZERO)) {
                        if (new BigInteger(s.substring(j, chars.length)).equals(BigInteger.ZERO)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}