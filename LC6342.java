import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();

        Map<Integer, int[]> posMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                posMap.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = posMap.get(num);
            Set<Integer> set1 = rowMap.getOrDefault(pos[0], new HashSet<>());
            set1.add(num);
            if(set1.size() == mat[0].length) return i;
            rowMap.put(pos[0], set1);

            Set<Integer> set2 = colMap.getOrDefault(pos[1], new HashSet<>());
            set2.add(num);
            if(set2.size() == mat.length) return i;
            colMap.put(pos[1], set2);
        }
        return 0;
    }
}