class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] temp = mat;
        for (int i = 0; i < 4; i++) {
            temp = change(temp);
            int flag = 0;
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp[0].length; k++) {
                    if (temp[j][k] != target[j][k]) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                return true;
            }
        }
        return false;
    }

    public int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }
}