class Solution {
    public double largestTriangleArea(int[][] points) {
        double a;
        double b;
        double c;
        double p;
        double maxSqrt=0;
        double sqrt;
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                for (int k = j + 1; k < points.length; k++) {
                    a=Math.sqrt(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                    b=Math.sqrt(points[j][0]-points[k][0])*(points[j][0]-points[k][0])+(points[j][1]-points[k][1])*(points[j][1]-points[k][1]);
                    c=Math.sqrt(points[k][0]-points[i][0])*(points[k][0]-points[i][0])+(points[k][1]-points[i][1])*(points[k][1]-points[i][1]);
                    p=(a+b+c)/2;
                    sqrt = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    maxSqrt = Math.max(sqrt, maxSqrt);
                }
            }
        }
        return maxSqrt;
    }


}