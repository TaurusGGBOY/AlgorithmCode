class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        while (homePos[0] > startPos[0]) {
            cost += rowCosts[++startPos[0]];
        }
        while (homePos[0] < startPos[0]) {
            cost += rowCosts[--startPos[0]];
        }
        while (homePos[1] > startPos[1]) {
            cost += colCosts[++startPos[1]];
        }
        while (homePos[1] < startPos[1]) {
            cost += colCosts[--startPos[1]];
        }
        return cost;
    }
}