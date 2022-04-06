import java.util.*;

class Solution {
    public int[][] findContinuousSequence(int target) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int max = 0;
        List<List<Integer>> list = new ArrayList<>();

        while (r < target) {
            while(sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    temp.add(i);
                }
                list.add(temp);
                max = Math.max(temp.size(), max);
            }
            sum += r;
            r++;
        }
        int[][] res = new int[list.size()][max];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            for (int j = 0; j < temp.size(); j++) {
                res[i][j] = temp.get(j);
            }
        }
        return res;
    }
}