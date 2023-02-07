import java.util.Arrays;

class Solution {
    int[] dis;
    boolean[] canPass;
    boolean[] vis;
    public int catMouseGame(int[][] graph) {
        dis = new int[graph.length];
        canPass = new boolean[graph.length];
        redVis = new boolean[graph.length];
        dfs(2);
        int[] cat = Arrays.copyOf(dis, dis.length);
        Arrays.fill(dis, -1);
        dfs(1);
        int[] mouse = Arrays.copyOf(dis, dis.length);
        int flag = 1;
        for (int i = 2; i < cat.length; i++) {
            if (mouse[i] - cat[i] >= 0 && (mouse[i] - cat[i]) % 2 == 0) {
                canPass[i] = true;
                flag = 0;
            }
        }
        if (flag == 1) {
            return 2;
        }

        if (findPath(1)) {
            return
        }
        return ;
    }

    boolean findPath(int index) {
        if (index == 0) {
            return true;
        }
    }

    void dfs(int index) {

    }


}