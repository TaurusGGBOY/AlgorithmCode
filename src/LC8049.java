class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

        int xDis = Math.abs(sx - fx);
        int yDis = Math.abs(sy - fy);
        int minDis = xDis + yDis;
        if (t == 0 && minDis != 0) {
            return false;
        }

        if (t == 1 && minDis == 0) {
            return false;
        }

        minDis -= Math.min(xDis, yDis);

//        System.out.println();
//        System.out.println(xDis);
//        System.out.println(yDis);
//        System.out.println(minDis);

        return t >= minDis;

    }
}