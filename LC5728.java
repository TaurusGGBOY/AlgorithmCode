// TODO 失败
import java.util.Arrays;

class Solution {
    public int minSideJumps(int[] obstacles) {
        // 维护一个数组看当前赛道最远到哪
        int n = obstacles.length;
        int[][] far = new int[3][n];
        // 记录一下当前最远pos
        int[] currPos = new int[3];
        Arrays.fill(currPos, n);
        for (int i = obstacles.length - 1; i >= 0; i--) {
            if (obstacles[i] > 0)
                currPos[obstacles[i] - 1] = i;
            for (int j = 0; j < 3; j++) {
                far[j][i] = currPos[j];
            }
        }
        // 在第二赛道开始
        int pos = 1;
        int res = 0;
        for (int i = 0; i < obstacles.length - 1; i++) {
            // 如果下一个赛道不能走
            if (obstacles[i + 1] == pos) {
                // 找三个赛道里面能走最远的跳过去
                int minPos = pos;
                for (int j = 0; j < 3; j++) {
                    if (far[j][i] > far[minPos][i]) {
                        minPos = j;
                    }
                }
                res++;
            }
        }
        return res;

    }
}