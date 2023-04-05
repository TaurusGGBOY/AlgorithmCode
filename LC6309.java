import java.math.BigInteger;

class Solution {

    public int findValidSplit(int[] nums) {
        int[] dp1 = new int[(int) 1e6 + 1];
        int[] dp2 = new int[(int) 1e6 + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = 2;
            while (j * j <= num) {
                if (num % j != 0) j++;
                else {
                    num /= j;
                    dp1[j]++;
                }
            }
            if (num != 0) dp1[num]++;
        }
        for (int i = 0; i < dp1.length; i++) {
            if (dp1[i] != 0) {
                System.out.print("[" + i + "," + dp1[i] + "],");
            }
        }
        System.out.println();
        int allNotZero = 0;
        int allEqual = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int j = 2;
            while (j * j <= num) {
                if (num % j != 0) j++;
                else {
                    num /= j;
                    dp2[j]++;
                    if (dp2[j] == 1) allNotZero++;
                    if (dp2[j] == dp1[j]) allEqual++;
                    if (allEqual == allNotZero) {
                        return i;
                    }
                }
            }
            if (num != 0) {
                dp2[num]++;
                if (dp2[num] == 1) allNotZero++;
                if (dp2[num] == dp1[num]) allEqual++;
                if (allEqual == allNotZero) {
                    return i;
                }
            }

        }
        return -1;
    }

}