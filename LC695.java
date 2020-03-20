class Solution {
        int maxNum = Integer.MIN_VALUE;
        int count=1;
        int[][] visit;
        public int maxAreaOfIsland(int[][] grid) {
            visit=new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for(int j=0;j<grid[0].length;j++)
                {
//                    System.out.println("第"+i+j);
                    count=1;
                    dfs(grid, i, j);
                }
            }
            return Math.max(maxNum,0);
        }

        void dfs(int[][] grid, int i, int j) {
            if(i<0||i>=grid.length||j<0||j>=grid[0].length)
                return;
            if(visit[i][j]==1)
                return;
            visit[i][j]=1;
            if(grid[i][j]!=1)
                return;
            grid[i][j]=count++;
            if(grid[i][j]>maxNum)
            {
//                System.out.print(i);
//                System.out.print(j);
//                System.out.println(grid[i][j]);
                maxNum=grid[i][j];
            }
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }