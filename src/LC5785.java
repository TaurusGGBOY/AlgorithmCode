import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> collect = Arrays.stream(triplets).filter((triplet) -> triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]).collect(Collectors.toList());
        int[] flag = new int[3];
        for (int[] ints : collect) {
            for (int i = 0; i < flag.length; i++) {
                if (ints[i] == target[i]) {
                    flag[i] = 1;
                }
            }
        }
        for (int i : flag) {
            if (i==0) {
                return false;
            }
        }
        return true;
    }
}