import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Vector;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxx = Math.max(horizontalCuts[0],h-horizontalCuts[horizontalCuts.length-1]);
        long maxy = Math.max(verticalCuts[0],w-verticalCuts[verticalCuts.length-1]);
        for(int i  =0;i<horizontalCuts.length-1;i++)
        {
            maxx = Math.max(maxx, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for(int i  =0;i<verticalCuts.length-1;i++)
        {
            maxy = Math.max(maxy, verticalCuts[i + 1] - verticalCuts[i]);
        }
        int res = (int)((maxx*maxy)%1000000007);
        return res;

    }
}