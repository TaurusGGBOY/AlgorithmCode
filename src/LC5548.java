import java.util.Arrays;

// TODO：这个解法不对
class Solution {
    // visited: 1:ing 2:ed
    int[][] visited;

    // res: -1: not yet
    int[][] res;

    final static int[][] dis = {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 1 && heights[0].length == 1)
            return 0;
        visited = new int[heights.length][heights[0].length];
        res = new int[heights.length][heights[0].length];
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i],-1);
        }

        getMinHeight(heights, 0, 0);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        return res[0][0];
    }

    public int getMinHeight(int[][] heights, int x, int y) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length)
            return -1;
        if (visited[x][y] != 0)
            return res[x][y];
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            res[x][y] = 0;
            visited[x][y] = 2;
            return 0;
        }
        if(x==1&&y==2)
        {
            System.out.println("tag1");
            for (int i = 0; i < res.length; i++) {
                System.out.println(Arrays.toString(res[i]));
            }
        }
//        System.out.println(x+" "+y);
        visited[x][y] = 1;
        int[] tblr = new int[4];
        for(int i =0;i<4;i++)
        {
            tblr[i]=getMinHeight(heights, x+dis[i][0], y+dis[i][1]);
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i<4;i++)
        {
            if(tblr[i]!=-1)
            {
                int temp = Math.max(Math.abs(heights[x][y] - heights[x+dis[i][0]][y+dis[i][1]]), tblr[i]);
                min = Math.min(temp, min);
            }
        }

        res[x][y] = min;
        visited[x][y]=2;
        if(x==1&&y==2)
        {
            System.out.println("tag2");
            for (int i = 0; i < res.length; i++) {
                System.out.println(Arrays.toString(res[i]));
            }
        }
        return min;
    }
}
//tag1
//        [-1, -1, -1]
//        [-1, -1, -1]
//        [-1, -1, -1]
//        tag2
//        [-1, -1, -1]
//        [-1, -1, 3]
//        [-1, -1, 0]
//        [2, 3, 3]
//        [2, 6, 3]
//        [2, 2, 0]
//        tag1
//        [-1, -1, -1]
//        [-1, -1, -1]
//        [-1, -1, -1]
//        tag2
//        [-1, -1, -1]
//        [-1, -1, 1]
//        [-1, -1, 0]
//        [1, 1, 1]
//        [2, 4, 1]
//        [2, 2, 0]
//        tag1
//        [-1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1]
//        tag2
//        [-1, -1, -1, 0, 0]
//        [-1, -1, 1, 1, 0]
//        [-1, -1, 1, 1, 0]
//        [-1, -1, 1, 1, 0]
//        [-1, -1, 1, 1, 0]
//        [1, 1, 0, 0, 0]
//        [1, 1, 1, 1, 0]
//        [1, 1, 1, 1, 0]
//        [1, 1, 1, 1, 0]
//        [1, 1, 1, 1, 0]
