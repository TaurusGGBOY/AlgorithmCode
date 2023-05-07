import java.util.*;

class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        Arrays.sort(temp);
        int count = 0;
        for (int j = 0; j < heights.length; j++) if (heights[j] != temp[j]) count++;
        return count;

    }
}