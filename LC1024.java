import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] maxRight = new int[T];
        for (int[] clip : clips) {
            if(clip[0]>=T)
                continue;
            if (clip[1] > maxRight[clip[0]]) {
                maxRight[clip[0]] = clip[1];
            }
        }
//        System.out.println(Arrays.toString(maxRight));
        int time = 0;
        int left = 0;
        int right = maxRight[0];
        time++;
        while (right < T) {
//            System.out.println("startRight"+right);
            int temp = right;
            for (int i = left; i <= temp; i++) {
                if (maxRight[i] > right)
                    right = maxRight[i];
            }
            if (right == temp)
                return -1;
            left = temp;
            time++;
//            System.out.println(right);
        }
//        System.out.println();
        return time;
    }
}
//java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
//        at line 7, Solution.videoStitching
//        at line 54, __DriverSolution__.__helper__
//        at line 87, __Driver__.main