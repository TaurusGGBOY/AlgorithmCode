import java.util.*;

class Solution {
    public int minOperations(List<Integer> nums, int target) {
        String s = Integer.toBinaryString(target);

        int[] total = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (num >> i == 1) {
                    total[i]++;
                }
            }
        }

//        System.out.println(Arrays.toString(total));

        int res = 0;
        for (int i = 0; i < total.length; i++) {
            if (i > 0) {
                total[i] += total[i - 1] / 2;
            }
            if (((target >> i) & 1) == 1) {
                if (total[i] > 0) {
                    total[i]--;
                    continue;
                }
                boolean flag = false;
                for (int j = i; j < 32; j++) {
                    if (total[j] > 0) {
                        res += j - i;
                        total[j]--;
                        for (int k = i; k < j; k++) {
                            total[k]++;
                        }
//                        System.out.println("choose:" + j);
//                        System.out.println("need:" + i);
                        flag = true;
//                        System.out.println(Arrays.toString(total));
                        break;
                    }
                }
                if (!flag) {
                    return -1;
                }
            }
        }
//        System.out.println();
        return res;
    }
}