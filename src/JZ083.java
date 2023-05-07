import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, nums.length - 1);
        return res;
    }

    void dfs(int[] nums, int l, int r) {
        if (l == r) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(nums, l, i);
            dfs(nums, l + 1, r);
            swap(nums, l, i);
        }
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}