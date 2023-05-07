import java.util.Arrays;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        char c = suits[0];
        boolean flag1 = false;
        for (int i = 1; i < suits.length; i++) {
            if (c != suits[i]) flag1 = true;
        }
        if (!flag1) return "Flush";

        for (int i = 0; i < ranks.length; i++) {
            for (int j = i + 1; j < ranks.length; j++) {
                for (int k = j + 1; k < ranks.length; k++) {
                    if (ranks[i] == ranks[j] && ranks[j] == ranks[k]) return "Three of a Kind";
                }
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            for (int j = i + 1; j < ranks.length; j++) {
                if (ranks[i] == ranks[j]) return "Pair";
            }
        }

        return "High Card";
    }
}