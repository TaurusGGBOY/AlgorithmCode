class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 0; i < heights.length - 1; i++) {
            int dis = heights[i + 1] - heights[i];
            if (dis > 0) {
                if (dis > bricks) {
                    if (ladders > 0)
                        ladders--;
                    else
                        return i;
                } else {
                    bricks -= dis;
                }
            }
        }
        return heights.length-1;
    }
}