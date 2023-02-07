<<<<<<< HEAD
import java.util.Arrays;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k]-o1[k]);
        return score;
=======
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
>>>>>>> b89ac05cd5cbe3580699ad0ddc998682f21b2ea9
    }
}