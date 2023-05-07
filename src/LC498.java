class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int l = 0, r = 0, count = 0, d = 0;
        while (count < mat.length * mat[0].length) {
            res[count] = mat[l][r];
            if (d == 0) {
                l--;
                r++;
                if (r >= mat[0].length) {
                    l += 2;
                    r--;
                    d = 1;
                } else if (l < 0) {
                    l++;
                    d = 1;
                }
            } else {
                l++;
                r--;
                if (l >= mat.length) {
                    r += 2;
                    l--;
                    d = 0;
                } else if (r < 0) {
                    r++;
                    d = 0;
                }
            }
            count++;
        }
        return res;
    }
}