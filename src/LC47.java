import java.util.*;

class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        redVis = new boolean[nums.length];
        list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    void dfs(int[] nums) {
        if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 保证不会出现 111 index为123 只能按照123的下标取，不会按照213 312 321等顺序 也可以自定义顺序
            if (redVis[i] || (i > 0 && nums[i] == nums[i - 1] && !redVis[i - 1])) continue;
            redVis[i] = true;
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size() - 1);
            redVis[i] = false;
        }
    }
}