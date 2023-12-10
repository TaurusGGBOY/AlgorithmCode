import java.math.BigInteger;
import java.util.*;

class Solution {
    public int numberOfGoodPartitions(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] next = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            next[i] = map.getOrDefault(nums[i], -1);
            map.putIfAbsent(nums[i], i);
        }

        int counter = 0;
        int index = 0;
        while (index < nums.length) {
            int n = next[index];
            ++counter;
            if (n == -1) {
                ++index;
            } else {
                int start = index;
                int end = next[index];
                while (true) {
                    int maxIndex = end;
                    for (int i = start; i <= end; ++i) {
                        maxIndex = Math.max(maxIndex, next[i]);
                    }

                    if (maxIndex != end) {
                        start = end + 1;
                        end = maxIndex;
                    } else {
                        index = end + 1;
                        break;
                    }
                }

            }
        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        System.out.println();
        return BigInteger.TWO.modPow(BigInteger.valueOf(counter - 1), BigInteger.valueOf(1000000007)).intValue();
    }

}