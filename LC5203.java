import java.util.Arrays;

class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] m = new int[n][n];
        int[] count = new int[artifacts.length];
        for (int i = 0; i < m.length; i++) {
            Arrays.fill(m[i], Integer.MIN_VALUE);
        }
        int res = 0;
        for (int k = 0; k < artifacts.length; k++) {
            int[] a = artifacts[k];
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    m[i][j] = k;
                    count[k]++;
                }
            }
        }
        for (int i = 0; i < dig.length; i++) {
            int[] d = dig[i];
//            System.out.println(Arrays.toString(count));
            if(m[d[0]][d[1]] == Integer.MIN_VALUE) continue;
            count[m[d[0]][d[1]]]--;
            if (count[m[d[0]][d[1]]] == 0) {
//                System.out.println(Arrays.toString(d));
//                System.out.println();
                res++;
            }
            m[d[0]][d[1]] = Integer.MIN_VALUE;
        }
        return res;
    }
}