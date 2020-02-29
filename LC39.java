import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> listlist = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();
        dfs(0, candidates, 0, target, list);
        return listlist;
    }

    void dfs(int order, int[] candidates, int current, int target, List<Integer> list) {
        if (current == target) {
            List<Integer> list2 = new ArrayList<>();
            list2.addAll(list);
            listlist.add(list2);
            System.out.println(list2.toString());
            return;
        }
        if (order == candidates.length) {
            return;
        }
        for (int i = 0; i <= (target - current) / candidates[order]; i++) {
            for (int j = 0; j < i; j++) {
                list.add(candidates[order]);
            }
            dfs(order + 1, candidates, current + i * candidates[order], target, list);
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }

    }
}