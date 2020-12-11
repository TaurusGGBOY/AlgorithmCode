import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]-o1[0])-(o2[1]-o2[0]);
            }
        });
        int leftCost = 0;
        int rightCost = Integer.MAX_VALUE;
        int minCost = Integer.MAX_VALUE;
        while (leftCost <= rightCost) {
//            System.out.println(leftCost + " " +rightCost+ " "+minCost);
            int initM = (leftCost + rightCost) / 2;
            int m = initM;
            int i;
            for (i = tasks.length - 1; i >= 0; i--) {
                if (m < tasks[i][1]) {
                    leftCost = initM + 1;
                    break;
                } else {
                    m -= tasks[i][0];
                }
            }
            if (i < 0) {
                minCost = Math.min(minCost, initM);
                rightCost = initM - 1;
            }
        }
        return minCost;
    }

}