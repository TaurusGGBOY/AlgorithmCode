import java.util.Arrays;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int[] counter = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();

        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                ++times;
            }
            counter[i] = times;
        }

//        System.out.println(Arrays.toString(counter));

        long res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int index = find(counter, nums[i] == max ? counter[i] + k - 1 : counter[i] + k);
//            System.out.println("find:" + counter[i] + k + " index:" + index);
            if (index != -1) {
                res += nums.length - index;
            }
        }

        return res;

    }

    int find(int[] counter, int num) {
        int l = 0;
        int r = counter.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (counter[m] < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return counter[l] == num ? l : -1;
    }
}