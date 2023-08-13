class Solution {
    static int length = 100001;

    public int maximumBeauty(int[] nums, int k) {
        int res = 0;

        int sum = nums.length;
        int[] counter = new int[length];
        for (int num : nums) {
            counter[num]++;
        }
        int[] prefix = new int[length];
        int[] subfix = new int[length];

        prefix[0] = 0;
        for (int i = 1; i < length; ++i) {
            prefix[i] = prefix[i - 1] + counter[i - 1];
        }

        subfix[subfix.length - 1] = 0;
        for (int i = subfix.length - 2; i >= 0; --i) {
            subfix[i] = subfix[i + 1] + counter[i + 1];
        }

        for (int i = 0; i < counter.length; i++) {
            int right = i + k > subfix.length - 1 ? 0 : subfix[i + k];
            int left = i - k < 0 ? 0 : prefix[i - k];
            res = Math.max(res, sum - left - right);
        }

        return res;
    }
}