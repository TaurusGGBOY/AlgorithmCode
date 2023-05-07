//TODO:失败
class Solution {
    public int maxCoins(int[] nums) {
        /**
         * @Author Nyr
         * @Date 2019/11/30 01:43
         * @Param
         * @Return
         * @Exception
         * @Description 动态规划解法
         */
        //避免空指针异常
        if (nums == null) {
            return 0;
        }

        //创建虚拟边界
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;
        length = nums2.length;

        //创建dp表
        length = nums2.length;
        int[][] dp = new int[length][length];

        //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        // 3. 为什么从末端开始？ 如果从头开始？？
        // 4. 边界是怎么搞的
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;
                // 1. 先看最里面一层 一次就能确定i到j的最大值
                for (int k = i + 1; k < j; k++) {
                    // 2. ik kj默认就是最优？ 因为j初始是i+2 所以就成了dp[i][i+1]
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }
}