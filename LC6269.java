class Solution {
    int res;
    boolean[] vis;

    public int closetTarget(String[] words, String target, int startIndex) {
        res = Integer.MAX_VALUE;
        vis = new boolean[words.length];

        boolean flag = false;
        for (String word : words) {
            if (target.equals(word)) {
                flag = true;
            }
        }
        if (!flag) return -1;

        dfs(words, target, startIndex, 0);
        dfs(words, target, startIndex, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    void dfs(String[] words, String target, int startIndex, int depth) {
        if (depth > res) return;
        if (words[startIndex].equals(target)) {
            res = Math.min(res, depth);
            return;
        }
        int left = (startIndex + 1) % words.length;
        int right = (startIndex - 1 + words.length) % words.length;
        vis[startIndex] = true;
        if (!vis[left]) dfs(words, target, left, depth + 1);
        if (!vis[right]) dfs(words, target, right, depth + 1);
        vis[startIndex] = false;
    }
}