class Solution {

    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, c, 0, 0, new ArrayList<>(), t);
        return res;
    }

    void dfs(List<List<Integer>> res, int[] c, int pos, int sum, List<Integer> list, int t) {
        if (sum == t) res.add(new ArrayList<>(list));
        if (sum >= t) return;
        for (int i = pos; i < c.length; i++) {
            list.add(c[i]);
            dfs(res, c, i, sum + c[i], list, t);
            list.remove(list.size() - 1);
        }
    }
}