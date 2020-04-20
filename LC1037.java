class Solution {
    public boolean isBoomerang(int[][] points) {
        double a = dis(points[0],points[1]);
        double b = dis(points[2],points[1]);
        double c = dis(points[0],points[2]);
        double s = (a + b + c) / 2f;
        double S = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return S>=0.0000000000001;
    }

    double dis(int[] point1, int[] point2) {
        return Math.sqrt((point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]));
    }
}