class Solution {
    public int averageValue(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if(num % 6 == 0) {
                res += num;
                count++;
            }
        }
        if(count == 0) return 0;
        return res / count;
    }
}