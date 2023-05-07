import java.util.PriorityQueue;

class Solution {

    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o, p) -> o[0] - p[0]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (queue.offer(new int[3]);;) {
            int[] poll = queue.poll();
            if (poll[1] == grid.length - 1 && poll[2] == grid[0].length) {
                return poll[0];
            } else if (poll[1] >= 0 && poll[1] < grid.length && poll[2] >= 0 && poll[2] < grid[0].length
                    && !visited[poll[1]][poll[2]]) {
                visited[poll[1]][poll[2]] = true;
                queue.offer(new int[] { poll[0] + grid[poll[1]][poll[2]], poll[1] - 1, poll[2] });
                queue.offer(new int[] { poll[0] + grid[poll[1]][poll[2]], poll[1], poll[2] - 1 });
                queue.offer(new int[] { poll[0] + grid[poll[1]][poll[2]], poll[1], poll[2] + 1 });
                queue.offer(new int[] { poll[0] + grid[poll[1]][poll[2]], poll[1] + 1, poll[2] });
            }
        }
    }
}
