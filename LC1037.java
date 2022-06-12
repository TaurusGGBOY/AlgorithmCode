class Solution {
    public boolean isBoomerang(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            if(points[i][0] == points[(i+1)%points.length][0] && points[i][1] == points[(i+1)%points.length][1]) return false;
        }
        int[] k1 = new int[]{points[0][0] - points[1][0], points[0][1] - points[1][1]};
        int[] k2 = new int[]{points[1][0] - points[2][0], points[1][1] - points[2][1]};
        int[] k3 = new int[]{points[2][0] - points[0][0], points[1][1] - points[0][1]};
        if ((k1[0] == 0 && k2[0] == 0) || (k2[0] == 0 && k3[0] == 0) || (k3[0] == 0 && k1[0] == 0)) return false;
        if ((k1[1] == 0 && k2[1] == 0) || (k2[1] == 0 && k3[1] == 0) || (k3[1] == 0 && k1[1] == 0)) return false;
        int gcd1 = gcd(k1[0], k1[1]);
        int gcd2 = gcd(k2[0], k2[1]);
        int gcd3 = gcd(k3[0], k3[1]);
        k1[0] /= gcd1;
        k2[1] /= gcd1;
        k1[0] /= gcd2;
        k1[1] /= gcd2;
        k3[0] /= gcd3;
        k3[1] /= gcd3;
        return !((k1[0] == k2[0] && k1[1] == k2[1]) || (k2[0] == k3[0] && k2[1] == k3[1]) || (k3[0] == k1[0] && k3[1] == k1[1]));
    }

    int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }

}