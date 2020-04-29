// 失败

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] arr = new int[M.length][M[0].length];
        int hang = M.length;
        int lie = M[0].length;
        for(int i = 0;i<hang;i++) {
            for(int j = 0;j<lie;j++) {
                int count = 0;
                for(int ii = i-1;ii<=i+1;ii++) {
                    for(int jj = j-1;jj<=j+1;jj++) {
                        if(ii>=0&&ii<hang&&jj>=0&&jj<lie) {
                            arr[i][j]+=M[ii][jj];
                            count++;
                        }
                    }
                }
                arr[i][j] = arr[i][j]/count;
            }
        }
        return arr;


    }
}



