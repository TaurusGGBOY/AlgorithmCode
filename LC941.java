class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int[][] riseOrDown = new int[A.length][2];
        riseOrDown[0][0] = 1;
        riseOrDown[A.length - 1][1] = 1;
        for (int i = 1; i < A.length; i++) {
            if (riseOrDown[i - 1][0] == 1 && A[i] > A[i - 1]) {
                riseOrDown[i][0] = 1;
            } else {
                riseOrDown[i][0] = 0;
            }
            if (riseOrDown[A.length - i][1] == 1 && A[A.length - i - 1] > A[A.length - i]) {
                riseOrDown[A.length - i - 1][1] = 1;
            } else {
                riseOrDown[A.length - i - 1][1] = 0;
            }
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (riseOrDown[i][0] == 1 && riseOrDown[i][1] == 1)
                return true;
        }
        return false;
    }
}