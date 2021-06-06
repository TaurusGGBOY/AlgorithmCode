// TODO 失败
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collector;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        long count = Arrays.stream(strs).filter(str -> {
            System.out.println(str);
            System.out.println(new BigInteger(str, 2).bitCount());
            System.out.println(str.length() - new BigInteger(str, 2).bitCount());
            System.out.println();
            return new BigInteger(str, 2).bitCount() <= n && str.length() - new BigInteger(str, 2).bitCount() <= m;
        }).count();
        return (int) count;
    }
}