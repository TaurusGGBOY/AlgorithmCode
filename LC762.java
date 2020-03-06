import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        for (int i = L; i <= R; i++)
            count += set.contains(Integer.bitCount(i)) ? 1 : 0;
        return count;
    }
}