import java.util.Arrays;
import java.util.Random;

class Solution {
    int topK;

    public int findKthLargest(int[] nums, int k) {
        topK = k - 1;
        partition(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//        System.out.println();
        return nums[topK];
    }

    void partition(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = randomQs(nums, l, r);
//        System.out.println("排了" + m + " " + nums[m]);
//        System.out.println(Arrays.toString(nums));
        if (topK == m) {
            return;
        }
        if (m > topK) {
            partition(nums, l, m - 1);
        } else {
            partition(nums, m + 1, r);
        }

    }

    int randomQs(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l) + l;
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;
        return qs(nums, l, r);
    }

    int qs(int[] nums, int l, int r) {
//        System.out.println("l,r:" + l + " " + r);
        int temp = nums[l];
        while (l < r) {
            while (l < r && temp >= nums[r]) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && temp <= nums[l]) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }
}
