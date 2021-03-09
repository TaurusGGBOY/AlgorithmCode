// TODO：失败

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    final static int MOD = 1000000007;
    static int[][] dis;
    static int[][] conn;
    static int[] visited;
    long res;

    public int countRestrictedPaths(int n, int[][] edges) {
        dis = new int[n + 1][n + 1];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
        }
        res = 0;
        // 1. 建图
        conn = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            dis[edge[0]][edge[1]] = edge[2];
            dis[edge[1]][edge[0]] = edge[2];
            conn[edge[1]][edge[0]] = 1;
            conn[edge[1]][edge[0]] = 1;
            dis[edge[0]][edge[0]] = 0;
            dis[edge[1]][edge[1]] = 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    dis[j][i] = dis[i][j];
                }
            }
        }
//        for (int i = 0; i < dis.length; i++) {
//            System.out.println(Arrays.toString(dis[i]));
//        }
        visited = new int[n + 1];
        for (int i = 2; i < n; i++) {
            visited[i] = 1;
            dfs(n, i);
            visited[i] = 0;
        }

        return (int) (res % MOD);
    }

    private void dfs(int n, int i) {
        if (i == 1) {
//            System.out.println(Arrays.toString(visited));
            res++;
            return;
        }
        for (int j = 1; j < n; j++) {
            if (visited[j] == 0 && dis[n][i] < dis[n][j] && conn[i][j] == 1) {
                visited[j] = 1;
                dfs(n, j);
                visited[j] = 0;
            }
        }
    }
}

//6
//[[6,2,9],[2,1,7],[6,5,10],[4,3,1],[3,1,8],[4,6,4],[5,1,7],[1,4,7],[4,5,3],[3,6,6],[5,3,9],[1,6,6],[3,2,2],[5,2,8]]