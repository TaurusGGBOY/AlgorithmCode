import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int[][] matrics;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        matrics = new int[R*C][2];
        int count=0;
        Point[] points = new Point[R*C];
        for(int i=0;i<R;i++)
        {
            for (int j = 0; j < C; j++) {
                Point point = new Point();
                point.x=i;
                point.y=j;
                point.dis=Math.abs(r0-i)+Math.abs(c0-j);
                points[count++] = point;
            }
        }
        Arrays.sort(points, new cmp());
        for (int i = 0; i < R * C; i++) {
            matrics[i][0]=points[i].x;
            matrics[i][1]=points[i].y;
        }
        return matrics;
    }

    private class Point
    {
        public int x;
        public int y;
        public int dis;
    }

    private class cmp implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.dis-o2.dis;
        }
    }


}