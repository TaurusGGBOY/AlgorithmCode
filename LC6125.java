import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            stringBuilder.setLength(0);
            for (int j = 0; j < grid[0].length; j++) {
                stringBuilder.append(grid[i][j]).append(",");
            }
            row.merge(stringBuilder.toString(), 1, Integer::sum);
        }

        for (int i = 0; i < grid[0].length; i++) {
            stringBuilder.setLength(0);
            for (int j = 0; j < grid.length; j++) {
                stringBuilder.append(grid[j][i]).append(",");
            }
            col.merge(stringBuilder.toString(), 1, Integer::sum);
        }
        int res  =0 ;

        for (Map.Entry<String, Integer> entry : row.entrySet()) {
            int count = col.getOrDefault(entry.getKey(), 0);
            res += count * entry.getValue();
        }
//        System.out.println(row.toString());
//        System.out.println(col.toString());
//        System.out.println();
        return res;
    }
}