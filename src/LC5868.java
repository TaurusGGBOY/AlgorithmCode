import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        long res = 0;
        for (int[] rectangle : rectangles) {
            int gcd = gcd(rectangle[0], rectangle[1]);
            rectangle[0] /= gcd;
            rectangle[1] /= gcd;
            Map<Integer, Integer> orDefault = map.getOrDefault(rectangle[0], new HashMap<>());
            int count = orDefault.getOrDefault(rectangle[1], 0);
            orDefault.put(rectangle[1], count + 1);
            map.put(rectangle[0], orDefault);
        }
        for (Map.Entry<Integer, Map<Integer, Integer>> entry1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : entry1.getValue().entrySet()) {
                BigInteger bigInteger1 = BigInteger.valueOf(entry2.getValue());
                BigInteger bigInteger2 = BigInteger.valueOf(entry2.getValue()-1);
                bigInteger1 = bigInteger1.multiply(bigInteger2);
                bigInteger1 = bigInteger1.divide(new BigInteger("2"));
                res += bigInteger1.longValue();
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}