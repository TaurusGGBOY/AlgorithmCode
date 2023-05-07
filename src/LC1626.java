import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> infs = new ArrayList<>();
        int[] dp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            infs.add(new int[]{scores[i], ages[i]});
        }
        infs.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < scores.length; i++) {
            dp[i] = infs.get(i)[0];
        }

        int res = Arrays.stream(dp).max().getAsInt();
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if (infs.get(j)[1] <= infs.get(i)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + infs.get(i)[0]);
                }
            }
            res = Math.max(dp[i], res);
        }
//        System.out.println(infs);
//        System.out.println(Arrays.toString(dp));
        return res;
    }
}