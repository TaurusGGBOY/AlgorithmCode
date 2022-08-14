import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int k : arr) set.add(k);
        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (!set.contains(arr[i] + arr[j])) continue;
                int temp1 = arr[i], temp2 = arr[j], len = 2;
                while (set.contains(temp1 + temp2)) {
                    temp2 = temp1 + temp2;
                    temp1 = temp2 - temp1;
                    max = Math.max(len++, max);
                }
            }
        }
        return max;
    }
}