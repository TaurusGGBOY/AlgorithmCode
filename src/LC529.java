import java.util.HashSet;
import java.util.Set;

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            int up = Math.max(click[0] - 1, 0);
            int down = Math.min(click[0] + 1, board.length - 1);
            int left = Math.max(click[1] - 1, 0);
            int right = Math.min(click[1] + 1, board[0].length - 1);

            Set<int[]> set = new HashSet<>();
            int count = 0;
            for (int i = up; i <= down; i++) {
                for (int j = left; j <= right; j++) {
                    if (i == click[0] && j == click[1]) {
                        continue;
                    } else if (board[i][j] == 'E') {
                        set.add(new int[]{i, j});
                    } else if (board[i][j] == 'M') {
                        count++;
                    }
                }
            }
            if (count == 0) {
                board[click[0]][click[1]] = 'B';
                for (int[] pair : set) {
                    updateBoard(board, pair);
                }
            } else {
                board[click[0]][click[1]] = (char) (count + '0');
            }
        }
        return board;
    }
}