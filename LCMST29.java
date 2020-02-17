class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null)
            return null;
        int state=0; // 0右 1下 2左 3上
        int h=matrix.length;
        int v = matrix[0].length;
        int right=1;
        int down=0;

        if(h<=1||v<=1)
            return matrix[0];

    }
}