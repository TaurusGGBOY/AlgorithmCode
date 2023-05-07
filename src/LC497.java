import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

class Solution {

    int[][] rects;
    int sum;
    TreeMap<Integer, int[]> map;
    Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        sum = 0;
        map = new TreeMap<>();
        // 左下x 左下y 右上x 右上y
        for (int i = 0; i < rects.length; i++) {
            map.put(sum, rects[i]);
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
    }

    public int[] pick() {
        // 选第多少个点 从0开始的
        int temp = random.nextInt(sum);
        //
        Map.Entry<Integer, int[]> entry = map.floorEntry(temp);
        int key = entry.getKey();
        int[] value = entry.getValue();
        // 你是当前的矩形中的第几个点 也是从0开始才对
        int count = temp - key;
        // 一行有多少个数
        int y = value[3] - value[1] + 1;
        //
        return new int[]{value[0] + count % y, value[1] + count % y == 0 ? count / y : count / y + 1};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */