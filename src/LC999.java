class Solution {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        int flag=0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
        }
        int height = board.length;
        int width = board[0].length;
        return bfs(-1, 0, i, j, height, width, board) + bfs(1, 0, i, j, height, width, board) + bfs(0, -1, i, j, height, width, board) + bfs(0, 1, i, j, height, width, board);
    }

    int bfs(int x, int y, int i, int j, int height, int width, char[][] board) {
        i += x;
        j += y;
        if (i < 0 || j < 0 || i >= height || j >= width)
            return 0;
        if (board[i][j] == 'B')
            return 0;
        if (board[i][j] == 'p')
            return 1;
        return bfs(x, y, i, j, height, width, board);
    }
}