
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int sum = 0;
            for (int num : nums) sum = sum + ((num >> i) & 1);
            sum %= 3;
            res += sum << i;
        }
        return res;
    }
}