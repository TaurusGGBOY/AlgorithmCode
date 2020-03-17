class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] clomn = new int[matrix[0].length];
        List<Integer> list = new ArrayList<>();
        int minNum = Integer.Max_Value;
        int minCol = 0;
        int minRow = 0;
        int minRowNum=0;
        for (int i = 0; i < matrix.length; i++) {
            minNum = Integer.Max_Value;
            minCol = 0;
            for (int j = 0; j < matrix[0].length; k++) {
                if (minNum > matrix[i][j]) {
                    minNum = matrix[i][j];
                    minCol = j;
                }
            }
            if (clomn[minCol] == 1)
                continue;
            clomn[minCol] = 1;
            minRowNum=minNum;
            minRow = i;
            for (int k = 0; k < matrix.length; k++) {
                if (minRowNum > matrix[k][minCol]) {
                    minRowNum = matrix[k][minCol];
                    minRow = k;
                }
            }
            if(minNum==minRowNum)
                list.add(minNum);

        }
        return list;
    }
}