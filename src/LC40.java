import java.util.*;

class Solution {
    Set<List<Integer>> set;
    List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        temp = new ArrayList<>();
        set = new HashSet<>();
        dfs(candidates, target, 0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(int[] candidates, int target, int sum, int pos) {
        if (target == sum) set.add(new ArrayList<>(temp));
        if (pos >= candidates.length || target <= sum) return;
        dfs(candidates, target, sum, pos + 1);
        temp.add(candidates[pos]);
        dfs(candidates, target, sum + candidates[pos], pos + 1);
        temp.remove(temp.size() - 1);
    }


}