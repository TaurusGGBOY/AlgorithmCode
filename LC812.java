class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double a_2 = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    double b_2 = (points[k][0] - points[j][0]) * (points[k][0] - points[j][0]) + (points[k][1] - points[j][1]) * (points[k][1] - points[j][1]);
                    double c_2 = (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]);
                    double sqaure = Math.sqrt(0.25 * (a_2 * c_2 - 0.5 * (a_2 + c_2 - b_2) * (a_2 + c_2 - b_2)));
                    res = Double.max(sqaure, res);
                }
            }
        }
        return res;
    }
}