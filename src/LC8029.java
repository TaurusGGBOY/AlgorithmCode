import java.util.Arrays;
import java.util.List;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] vis = new int[101];
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                vis[i] = 1;
            }
        }

        return Arrays.stream(vis).sum();
    }
}