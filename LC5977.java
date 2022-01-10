import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num == 1) {
                k++;
            }
        }
        int[] temp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            temp[nums.length + i] = nums[i];
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (temp[i] == 1) {
                count++;
            }
        }
//        System.out.println(k);
        res = k - count;
        for (int i = 1; i < nums.length; i++) {
            if (temp[i - 1] == 1) {
                count--;
            }
            if (temp[i-1 + k] == 1) {
                count++;
            }
            res = Math.min(k - count,res);
//            System.out.println(count);
        }
//        System.out.println();
        return res;
    }
}