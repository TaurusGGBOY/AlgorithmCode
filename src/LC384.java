import java.util.Random;

class Solution {
    int[] origin;

    public Solution(int[] nums) {
        origin = new int[nums.length];
        System.arraycopy(nums, 0, origin, 0, origin.length);
    }

    public int[] reset() {
        int[] temp = new int[origin.length];
        System.arraycopy(origin, 0, temp, 0, origin.length);
        return temp;
    }

    public int[] shuffle() {
        int[] temp = new int[origin.length];
        System.arraycopy(origin, 0, temp, 0, origin.length);
        for (int i = 0; i < origin.length; i++) {
            int j = new Random().nextInt(origin.length);
            int node = temp[j];
            temp[j] = temp[i];
            temp[i] = node;
        }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */