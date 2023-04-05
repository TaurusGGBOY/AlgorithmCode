import java.util.Arrays;

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int[] res = new int[2];
        for (int j = 0; j < divisors.length; j++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % divisors[j] == 0) count++;
            }
            if (count > res[1]) {
                res[0] = j;
                res[1] = count;
            }
        }
        if(res[1] == 0) {
            return Arrays.stream(divisors).min().getAsInt();
        }
        return divisors[res[0]];
    }
}
