import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(res, list, 0);
        return res;
    }

    // 每次确定一个数
    private void dfs(List<List<Integer>> res, List<Integer> list, int pos) {
        if (pos == list.size()) res.add(new ArrayList<>(list));
        for (int i = pos; i < list.size(); i++) {
            Collections.swap(list, pos, i);
            dfs(res, list, pos + 1);
            Collections.swap(list, pos, i);
        }
    }
}