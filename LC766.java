class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x;
        int y;
        for(int i=0;i<matrix[0].length;i++)
        {
            int temp = matrix[0][i];
            x=1;
            y=i+1;

            while(y<matrix[0].length&&x<matrix.length)
            {
                if(matrix[x++][y++]!=temp)
                    return false;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int temp = matrix[i][0];
            x=i+1;
            y=1;
            while(y<matrix[0].length&&x<matrix.length)
            {
                if(matrix[x++][y++]!=temp)
                    return false;
            }
        }
        return true;
    }
}