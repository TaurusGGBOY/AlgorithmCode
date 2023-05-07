class Solution {
    public int minCostToMoveChips(int[] chips) {
        int i = 0;
        for (int chip : chips) {
            i += (chip % 2 == 0) ? 1 : 0;
        }
        return Math.min(i, chips.length - i);
    }
}