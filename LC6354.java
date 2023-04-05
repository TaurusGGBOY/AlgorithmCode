import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        // 左边界
        int l = 1;
        for (; l < nums.length; l++) {
            if (nums[0] + nums[l] >= lower) break;
        }
        if (l == nums.length) l--;
        // 右边界
        int r = 1;
        for (; r < nums.length; r++) {
            if (nums[0] + nums[r] > upper) break;
        }
        if (r == nums.length) r--;
//        System.out.println(0 + " " + l + " " + r);

        // i上升，左边界应该是左移
        // i上升，右边界应该是左移
        // 左边是取不到的 右边是能取到的

        long res = 0;
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            l = Math.max(i + 1, l);
            if (l > r) break;
            while (r >= i + 1 && nums[i] + nums[r] > upper) r--;
            while (l >= i + 1 && nums[i] + nums[l] >= lower) l--;
//            System.out.println(i + " " + l + " " + r);
            res += r - l;
        }
        return res;

    }
}

