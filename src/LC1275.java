class Solution {
  public String tictactoe(int[][] moves) {
    int[][] go = new int[3][3];
    for (int i = 0; i < moves.length; i++) {
      go[moves[i][0]][moves[i][1]] = (int) Math.pow(-1 * 1.0f, i * 1.0f);
    }
    if (go[0][0] != 0 && go[0][0] == go[0][1] && go[0][1] == go[0][2])
      return go[0][0] == 1 ? "A" : "B";
    if (go[1][0] != 0 && go[1][0] == go[1][1] && go[1][1] == go[1][2])
      return go[1][0] == 1 ? "A" : "B";
    if (go[2][0] != 0 && go[2][0] == go[2][1] && go[2][1] == go[2][2])
      return go[2][0] == 1 ? "A" : "B";
    if (go[0][0] != 0 && go[0][0] == go[1][0] && go[1][0] == go[2][0])
      return go[0][0] == 1 ? "A" : "B";
    if (go[0][1] != 0 && go[0][1] == go[1][1] && go[1][1] == go[2][1])
      return go[0][1] == 1 ? "A" : "B";
    if (go[0][2] != 0 && go[0][2] == go[1][2] && go[1][2] == go[2][2])
      return go[0][2] == 1 ? "A" : "B";
    if (go[0][0] != 0 && go[0][0] == go[1][1] && go[1][1] == go[2][2])
      return go[0][0] == 1 ? "A" : "B";
    if (go[2][0] != 0 && go[2][0] == go[1][1] && go[0][2] == go[2][0])
      return go[2][0] == 1 ? "A" : "B";
    return go[0][0] == 0
            || go[0][1] == 0
            || go[0][2] == 0
            || go[1][0] == 0
            || go[1][1] == 0
            || go[1][2] == 0
            || go[2][0] == 0
            || go[2][1] == 0
            || go[2][2] == 0
        ? "Pending"
        : "Draw";
  }
}
