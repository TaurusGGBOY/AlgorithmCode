import java.math.BigInteger;
import java.util.*;

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];

            if (BigInteger.valueOf(v[0]).modPow(BigInteger.valueOf(v[1]), BigInteger.valueOf(10)).modPow(BigInteger.valueOf(v[2]), BigInteger.valueOf(v[3])).equals(BigInteger.valueOf(target))) {
                res.add(i);
            }

        }

        return res;
    }
}