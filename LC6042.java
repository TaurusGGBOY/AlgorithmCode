class Solution {
    public int countLatticePoints(int[][] circles) {
        int lx = -100;
        int ly = -100;
        int rx = 200;
        int ry = 200;
        int res = 0;
        for (int x = lx; x <= rx; x++) {
            for (int y = ly; y <= ry; y++) {
                for (int[] circle : circles) {
                    if ((x - circle[0]) * (x - circle[0]) + (y - circle[1]) * (y - circle[1]) <= circle[2] * circle[2]) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}