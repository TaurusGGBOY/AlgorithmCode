import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Line[] lines = new Line[mat.length];
        for (int i = 0; i < mat.length; i++) {
            lines[i] = new Line();
            lines[i].line=i;
            for(int j=0;j < mat[0].length;j++)
            {
                lines[i].military+=mat[i][j];
            }

        }
        Arrays.sort(lines,new cmp());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = lines[i].line;
        }
        return result;
    }

    private class Line {
        public int military;
        public int line;
    }

    private class cmp implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            if(o1.military!=o2.military)
                return o1.military-o2.military;
            return o1.line - o2.line;

        }
    }


}
