import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Long> map = new TreeMap<>();
        int mod = 1000000007;
        for (int d : deliciousness) {
            map.merge(d, 1l, Long::sum);
        }

        int[] sum = new int[22];
        sum[0] = 1;
        for (int i = 1; i <= 21; i++) {
            sum[i] = sum[i - 1] * 2;
        }

        long res = 0;
        for (int d : map.keySet()) {
            long dTime = map.get(d);
            for (int i = 0; i <= 21; i++) {
                int s = sum[i] - d;
                if (s < d) {
                    continue;
                }
                long sTime = map.getOrDefault(s, 0l);
                if (s == d) {
                    res = (res + dTime * (dTime - 1) / 2) % mod;
                } else {
                    res = (res + (dTime * sTime)) % mod;
                }
            }
        }
        return (int) res;
    }
}