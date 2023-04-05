import java.util.Arrays;

class Solution {

    public int findMinimumTime(int[][] tasks) {
        // 按照右边时间排序 需要注意的时候 没有管左端点
        Arrays.sort(tasks, (o, p) -> o[1] - p[1]);
        // visited是时间点 这个里面如果等于1 那么肯定已经加入counter
        int count = 0, visited[] = new int[20001];
        for (int[] task : tasks) {
            // 如果已经加入了counter那么不需要单独安排
            for (int i = task[0]; i <= task[1]; i++) {
                task[2] -= visited[i];
            }
            // 倒序安排
            for (int i = task[1]; i >= task[0] && task[2] > 0; i--) {
                // 如果这个节点==0就对不起 只有占用这个时间点了 因为是按照右端点排序的
                if (visited[i] == 0) {
                    task[2]--;
                    visited[i] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}