import java.util.Arrays;

class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[32];
        for (int candidate : candidates) {
            for (int i = 0; i < 32 && candidate > 0; i++) {
                count[i] += candidate & 1;
                candidate >>= 1;
            }
        }
        return Arrays.stream(count).max().getAsInt();
    }
}