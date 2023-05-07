class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3)
            return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        int ridge = 0;
        int temp = A[0];
        for (int i = 1; i < A.length; i++) {
            if (temp < A[i]) {
                ridge++;
            } else {
                ridge = 0;
            }
            temp = A[i];
            left[i] = ridge;
        }
        ridge = 0;
        int maxTop = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (temp < A[i]) {
                ridge++;
            } else {
                ridge = 0;
            }
            temp = A[i];

            if (left[i] != 0 && ridge != 0) {
                left[i] += ridge;
                maxTop = Math.max(left[i], maxTop);
            }
        }
        return maxTop == 0 ? 0 : maxTop + 1;
    }
}