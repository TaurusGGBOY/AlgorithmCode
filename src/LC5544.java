import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

class Solution {
    Set<String> set;
    String minString;

    public String findLexSmallestString(String s, int a, int b) {
//        System.out.println("开始");
        set = new HashSet<>();
        minString = s;
        set.add(s);
        dfs(s, a, b, 1);
        dfs(s, a, b, 2);
//        System.out.println("结束");
        return minString;
    }

    public void dfs(String s, int a, int b, int op) {
        String temp;
        if (op == 1)
            temp = op1(s, a);
        else
            temp = op2(s, b);
        if(set.contains(temp))
            return;
        set.add(temp);
        BigInteger b1 = new BigInteger(temp);
        BigInteger b2 = new BigInteger(minString);
        if(b1.compareTo(b2)<0)
            minString=temp;
        dfs(temp, a, b, 1);
        dfs(temp, a, b, 2);
    }


    public String op1(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            int temp = Integer.parseInt(String.valueOf(chars[2 * i + 1])) + a;
            chars[2 * i + 1] = temp > 9 ? (char) ('0' + temp-10) : (char) ('0' + temp);
        }
//        System.out.println("op1"+String.valueOf(chars));
        return String.valueOf(chars);
    }
    public String op2(String s, int b) {
//        System.out.println("原本 "+s);/**/
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(s.length() - b));
//        System.out.println("中途 "+stringBuilder.toString());
        stringBuilder.append(s, 0, s.length()- b);
//        System.out.println("op2 "+stringBuilder.toString());
        return stringBuilder.toString();
    }
}