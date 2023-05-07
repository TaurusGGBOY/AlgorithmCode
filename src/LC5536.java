import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<int[]> set = new HashSet<>();
        Map<Integer, Vector<Integer>> map = new HashMap<>();
        int[] zhi = new int[n];
        for (int[] road : roads) {
            Vector<Integer> vector = new Vector<>();
            if(map.containsKey(road[0]))
            {
                vector = map.get(road[0]);
            }
            vector.add(road[1]);
            map.put(road[0],vector);
            Vector<Integer> vector2 = new Vector<>();
            if(map.containsKey(road[1]))
            {
                vector2 = map.get(road[1]);
            }
            vector2.add(road[0]);
            map.put(road[1],vector2);
            zhi[road[0]]++;
            zhi[road[1]]++;
        }
        int[][] dp = new int[n][n];
        int max=0;
        for(int i =0;i<n;i++)
        {
            for(int j =i+1;j<n;j++)
            {
                dp[i][j]=zhi[i]+zhi[j];
                if(map.containsKey(i))
                {
                    if(map.get(i).contains(j))
                        dp[i][j]--;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;

    }
}