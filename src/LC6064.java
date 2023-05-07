import java.util.Arrays;

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = 0;
        for (int i = 0; i < special.length; i++) {
            int dis = special[i] - bottom;
            max = Math.max(dis, max);
            bottom = special[i] + 1;
        }
        max = Math.max(max, top - special[special.length - 1]);
        return max;
    }
}