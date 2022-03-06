import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, nums.length - 1, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int l, int r, List<Integer> list) {
        if (l == r) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, l, i);
            dfs(nums, l + 1, r, list);
            swap(nums, l, i);
        }
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}