import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numPrimeArrangements(int n) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        long l = 0, r = 0;
        long lRes = 1, rRes = 1;
        long mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) lRes = (lRes * ++l) % mod;
            else rRes = (++r * rRes) % mod;
        }
        return (int) ((lRes * rRes) % mod);

    }
}