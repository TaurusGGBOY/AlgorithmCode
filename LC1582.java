class Solution {
    public int numSpecial(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            int flag = 0;
            int x = 0;
            int y = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (flag == 1) {
                    if (mat[i][j] == 1) {
                        flag = 2;
                        break;
                    }
                } else if (flag == 0) {
                    if (mat[i][j] == 1) {
                        flag = 1;
                        x = i;
                        y = j;
                    }
                }
            }
            if (flag == 1) {
                visited[x][y] = 1;
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            int flag = 0;
            int x = 0;
            int y = 0;
            for (int j = 0; j < mat.length; j++) {
                if (flag == 1) {
                    if (mat[j][i] == 1) {
                        flag = 2;
                        break;
                    }
                } else if (flag == 0) {
                    if (mat[j][i] == 1) {
                        flag = 1;
                        x = j;
                        y = i;
                    }
                }
            }
            if (flag == 1 && visited[x][y] == 1) {
                count++;
            }
        }
        return count;
    }
}