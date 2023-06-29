
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank > 0) {
            int dis = Math.min(mainTank, 5);
            res += dis * 10;
            mainTank -= dis;
            if (dis == 5 && additionalTank > 0) {
                ++mainTank;
                --additionalTank;
            }
        }
        return res;
    }
}