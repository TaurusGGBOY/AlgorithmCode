class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        // 重点2：按照步长确定curr
        while (k > 0) {
             String s;
             s.contains()
            int cnt = getCount(curr, n);
            // 如果走了k步 会超过cnt，说明答案在兄弟结点
            if (cnt <= k) {
                k -= cnt;
                curr++;
            } else {
                // 如果走了k步，还没不能走到cnt 说明答案在子树上
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    // 重点1：按照curr生成字典树需要走的步数
    public int getCount(int curr, int n) {
        int count = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            count += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return count;
    }
}