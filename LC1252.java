class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] r = new int[n];
        int[] c = new int[m];
        for(int i=0;i<indices.length;i++)
        {
            r[indices[i][0]]++;
            c[indices[i][1]]++;
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count+=((r[i]+c[j])%2==0)?0:1;
            }
        }
        return count;
    }
}