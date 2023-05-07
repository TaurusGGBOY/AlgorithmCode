// TODO: 失败
// [16,34,41,55,41,32,13,43,25,34,57,8,32,25,55,48,57,19,47,54,58,15,49,52,45,32,10,26,19,53,58,37,3,32,21,11,7,7]
//60
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] sum = new int[2 * 100000];
        int most = 0;
        int mostSum = 0;
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i] + nums[nums.length - 1 - i];
            sum[temp]++;
            if (most < sum[temp]) {
                most = sum[temp];
                mostSum = temp;
                vector.clear();
                vector.add(temp);
            } else {
                if (most == sum[temp])
                    vector.add(temp);
            }
        }
        System.out.println(vector.toString());

        int minRes = Integer.MAX_VALUE;
        for (int integer : vector) {
            int res = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i] + nums[nums.length - 1 - i];
                int dis = Math.abs(integer - temp);
                if (dis == 0)
                    continue;
                else if ((nums[i] + 1 > integer || nums[i] + limit < integer) && (nums[nums.length - 1 - i] + 1 > integer || nums[nums.length - 1 - i] + limit < integer))
                    res += 2;
                else
                    res++;
            }
            minRes = Math.min(minRes, res);
        }

        return minRes;

    }
}
