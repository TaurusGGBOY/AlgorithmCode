
class Solution {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        if (rungs[0] % dist != 0) {
            count += rungs[0] / dist;
        } else {
            count += rungs[0] / dist - 1;
        }
        for (int i = 0; i < rungs.length - 1; i++) {
            if ((rungs[i + 1] - rungs[i]) % dist != 0) {
                count += (rungs[i + 1] - rungs[i]) / dist;
            } else {
                count += (rungs[i + 1] - rungs[i]) / dist - 1;
            }
        }
        return count;
    }
}