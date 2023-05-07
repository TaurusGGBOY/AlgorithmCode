class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;
        score1 = getScore(player1);

        score2 = getScore(player2);

        if (score1 == score2) return 0;
        return score1 > score2 ? 1 : 2;
    }

    private int getScore(int[] play) {
        int prev = -3;
        int score = 0;
        for (int i = 0; i < play.length; i++) {
            if (prev + 2 >= i) {
                score += play[i] * 2;
            } else {
                score += play[i];
            }
            if (10 == play[i]) prev = i;
        }
        return score;
    }
}