import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int minNum = Integer.MAX_VALUE;
        int minCol = 0;
        int maxRowNum=0;
        for (int i = 0; i < matrix.length; i++) {
            minNum = Integer.MAX_VALUE;
            minCol = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (minNum > matrix[i][j]) {
                    minNum = matrix[i][j];
                    minCol = j;
                }
            }
            maxRowNum=minNum;
            for (int k = 0; k < matrix.length; k++) {
                if (maxRowNum < matrix[k][minCol]) {
                    maxRowNum = matrix[k][minCol];
                }
            }
            if(minNum==maxRowNum)
                list.add(minNum);

        }
        return list;
    }
}