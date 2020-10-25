import java.util.Arrays;

// TODO：失败
class Solution {
    int[][] visited;
    int[][] res;

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 1 && heights[0].length == 1)
            return 0;
        visited = new int[heights.length][heights[0].length];
        res = new int[heights.length][heights[0].length];
        getMinHeight(heights, 0, 0, 0,0);
        for(int i =0;i<res.length;i++)
        {
            System.out.println(Arrays.toString(res[i]));
        }
        return res[0][0];
    }

    public int getMinHeight(int[][] heights, int x, int y, int fromx, int fromy ) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length)
            return -1;
        if (visited[x][y] == 1)
            return res[x][y];
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            res[x][y] = 0;
            visited[x][y] = 1;
            return 0;
        }
//        System.out.println(x+" "+y);
        visited[x][y] = 1;
        int top = getMinHeight(heights, x - 1, y,x,y);
        int button = getMinHeight(heights, x + 1, y,x,y);
        int left = getMinHeight(heights, x, y - 1,x,y);
        int right = getMinHeight(heights, x, y + 1,x,y);
        int min;
        min = Integer.MAX_VALUE;
        System.out.println(x+" "+y );
        System.out.println("top button left right" + top + button + left + right);
        if (top != -1) {
            if(x-1==fromx&&y==fromy)
            {

            }
            else
            {
                int temp = Math.max(Math.abs(heights[x][y] - heights[x - 1][y]), top);
                min = Math.min(min, temp);
            }

        }
        if (button != -1) {
            if(x+1==fromx&&y==fromy)
            {

            }
            else
            {
                int temp = Math.max(Math.abs(heights[x][y] - heights[x + 1][y]), button);
                min = Math.min(min, temp);
            }

        }
        if (left != -1) {
            if(x==fromx&&y-1==fromy)
            {

            }
            else
            {
                int temp = Math.max(Math.abs(heights[x][y] - heights[x][y-1]), left);
                min = Math.min(min, temp);
            }

        }
        if (right != -1) {
            if(x==fromx&&y+1==fromy)
            {

            }
            else
            {
                int temp = Math.max(Math.abs(heights[x][y] - heights[x][y+1]), right);
                min = Math.min(min, temp);
            }

        }
        res[x][y] = min;
        return min;

    }

}