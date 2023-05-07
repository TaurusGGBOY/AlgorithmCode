import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int[][] dis = new int[mat.length][mat[0].length - 1];
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                dis[i][j] = mat[i][j]-mat[i][j + 1];
            }
        }
        int[] pos = new int[mat.length];
        Arrays.fill(pos,mat.length - 1);
        int count = 1;
        while(count<k)
        {
          int minPos=0;
          int min = Integer.MAX_VALUE;
          for(int i =0;i<mat.length;i++)
          {
            if(pos[i]==0)
              continue;
            if(min>dis[i][pos[i]-1])
            {
              minPos=i;
              min=dis[i][pos[i]-1];
            }
          }

          count++;
        }

    }
}