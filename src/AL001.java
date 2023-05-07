import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class AL001 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 1, 0, 0}, {1, 0, 1, 0}};
        System.out.println(func(a));
    }

    static int func(int[][] a) {
        int[] rowMin = new int[a.length];
        int[] colMin = new int[a[0].length];
        int[] rowMax = new int[a.length];
        int[] colMax = new int[a[0].length];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);
        Arrays.fill(rowMax, Integer.MIN_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    rowMin[i] = Math.min(rowMin[i], i);
                    colMin[j] = Math.min(colMin[j], j);
                    rowMax[i] = Math.max(rowMax[i], i);
                    colMax[j] = Math.max(colMax[j], j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    count += rowMin[i] < i ? 1 : 0;
                    count += colMin[j] < j ? 1 : 0;
                    count += rowMax[i] > i ? 1 : 0;
                    count += colMax[j] > j ? 1 : 0;
                }
            }
        }
        return count;
    }
}
