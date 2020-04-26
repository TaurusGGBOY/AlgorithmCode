class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                for(int k=j+1;k<points.length;k++)
                {
                    Double sqrt = sqrt(points,i,j,k);

                    sqrt = sqrt.equals(Double.NaN) ? 0 : sqrt;
                    maxArea = Math.max(maxArea,sqrt);
//                    System.out.println(maxArea);
                }
            }
        }
//        System.out.println(maxArea);
        return maxArea;
    }

    double sqrt(int[][]points, int i,int j,int k)
    {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        int x3 = points[k][0];
        int y3 = points[k][1];

			/*
			 * 	已知A（x1,y1）,B（x2,y2）
			那么AB之间的距离为√[(X1－X2)^2+(Y1－Y2)^2]
			 * */

        /*
         * 点1至点2的距离
         *  求根的方法：Math.sqrt(double s);
         * */
        double first = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

        /*
         * 点2至点3的距离
         * */
        double second =  Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));

        /*
         * 点3至点1的距离
         * */
        double third = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));

        /*
         * 计算三角形面积
         * */
        double s = (first+second+third)/2;
        double area = Math.sqrt(s*(s-first)*(s-second)*(s-third));
        return area;
    }
}