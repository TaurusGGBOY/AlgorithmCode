import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int first = grid[0][0];
        List<Integer> list = new ArrayList<>();
        for (int[] ints : grid) {
            for (int i : ints) {
                if (((i - first) % x != 0)) {
                    return -1;
                }
                list.add(i);
            }
        }
        list.sort(null);
        int mid = list.get(list.size() / 2);
        int ans = 0;
        for (int integer : list) {
            ans += Math.abs((integer - mid)/x);
        }
        return ans;
    }
}