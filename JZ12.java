class Solution {
    int[][] vis;
    int[][] directions = new int[][]{{0, -1,}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        redVis = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int pos, int x, int y) {
        if (pos == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || redVis[x][y] == 1 || board[x][y] != word.charAt(pos))
            return false;
        redVis[x][y] = 1;

        for (int[] d : directions) {
            if (dfs(board, word, pos + 1, x + d[0], y + d[1])) return true;
        }
        redVis[x][y] = 0;
        return false;
    }
}