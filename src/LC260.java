class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        // 妙啊 和自己的负数异或
        int index = Integer.lowestOneBit(temp);
        int[] tempint = new int[2];
        for (int num : nums) {
            // 和自己的最小非0位异或来分类
            if ((num & index) == 0) {
                tempint[0] ^= num;
            } else {
                tempint[1] ^= num;
            }
        }
        return tempint;
    }
}