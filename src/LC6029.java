import java.util.*;

class Solution {
    int max;
    int[] res;
    int[] temp;
    int[] aA;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        max = 0;
        aA = aliceArrows;
        temp = new int[aliceArrows.length];
        res = new int[aliceArrows.length];
        dfs(0, numArrows, 0, false);
        if (numArrows >= aA[0] + 1) {
            temp[0] = aA[0] + 1;
            dfs(0, numArrows - (aliceArrows[0] + 1), 1, true);
        }
//        System.out.println(max);
        int sum = Arrays.stream(res).sum();
        res[0] += numArrows - sum;
        return res;
    }

    void dfs(int pos, int currentRemind, int currentScore, boolean willWin) {
        if (pos >= aA.length || currentRemind <= 0) {
            if (currentScore > max) {
                max = currentScore;
                System.arraycopy(temp, 0, res, 0, temp.length);
            }
            return;
        }
        if (willWin) {
            temp[pos] = aA[pos] + 1;
            currentRemind -= aA[pos] + 1;
            currentScore += pos;
        }else{
            temp[pos] = 0;
        }
        dfs(pos + 1, currentRemind, currentScore, false);
        if (pos < aA.length - 1 && currentRemind >= aA[pos + 1] + 1) {
            dfs(pos + 1, currentRemind, currentScore, true);
        }
    }
}