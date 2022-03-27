class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = 3;
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int count = 0;
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    for (int m = 0; m < n; m++) {
                        try {
                            sum += img[i + k - 1][j + m - 1];
                            count++;
                        } catch (Exception e) {

                        }
                    }

                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}