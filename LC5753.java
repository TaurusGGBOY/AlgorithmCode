import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {


    Set<Integer> parentsSet = new HashSet<>();

    public int largestPathValue(String colors, int[][] edges) {

        int[][][] dp = new int[edges.length][edges.length][colors.length()];
        // dp[i][j][k] i是起始点 j是终点 k是路上经过的颜色
        // 最后的答案是max(dp[i][j][k])

        Map<Integer, Integer> parents = new HashMap<>();
        char[] chars = colors.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            parents.put(i, i);
        }
        parentsSet = new HashSet<>();


    }

    int find(Map<Integer, Integer> parents, int index) {
        if (parents.get(index) == index) {
            return index;
        }
        return find(parents, parents.get(index));
    }

    void mergeParents(Map<Integer, Integer> parents, int from, int to) {
        parentsSet.add(find(parents, to));
        parents.put(find(parents, from), find(parents, to));
    }

}