import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    static int res;

    public int beautifulSubsets(int[] nums, int k) {
        res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, k, true, new TreeMap<>());
        }
        return res;
    }

    public void dfs(int[] nums, int pos, int k, boolean vis, TreeMap<Integer, Integer> banList) {
        if (pos >= nums.length) return;
        if (vis) {
            if (banList.getOrDefault(nums[pos], 0) > 0) return;
            banList.merge(nums[pos] + k, 1, Integer::sum);
            res++;
//            System.out.println(banList);
        }
        dfs(nums, pos + 1, k, true, banList);
        dfs(nums, pos + 1, k, false, banList);
        if (vis) {
            if (banList.get(nums[pos] + k) == 1) banList.remove(nums[pos] + k);
            else banList.put(nums[pos] + k, banList.get(nums[pos] + k) - 1);
        }
    }
}