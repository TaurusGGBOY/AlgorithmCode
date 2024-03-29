import java.util.Random;

class Solution {

    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
                if(random.nextInt(count) == 0){
                    res = i;
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */