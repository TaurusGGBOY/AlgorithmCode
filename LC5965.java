import java.util.Arrays;

class Solution {
    public long[] getDistances(int[] arr) {
        long[] sum = new long[100005];
        int[] lastPos = new int[100005];
        int[] count = new int[100005];
        long[] res = new long[arr.length];
        Arrays.fill(lastPos, -1);
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (lastPos[num] == -1) {
                lastPos[num] = i;
                count[num]++;
            } else {
                sum[num] = (i - lastPos[num]) * count[num] + sum[num];
                lastPos[num] = i;
                count[num]++;
            }
            res[i] = sum[num];
        }
        long[] sum2 = new long[100005];
        int[] lastPos2 = new int[100005];
        int[] count2 = new int[100005];
        long[] res2 = new long[arr.length];
        Arrays.fill(lastPos, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (lastPos2[num] == -1) {
                lastPos2[num] = i;
                count2[num]++;
            } else {
                sum2[num] = (-i + lastPos2[num]) * count2[num] + sum2[num];
                lastPos2[num] = i;
                count2[num]++;
            }
            res[i] += sum2[num];
        }
        return res;
    }
}