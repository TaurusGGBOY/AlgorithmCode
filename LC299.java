class Solution {
    public String getHint(String secret, String guess) {
        String res = "";
        int[] guessA = new int[10];
        int[] guessB = new int[10];
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            guessA[secret.charAt(i) - '0']++;
            guessB[guess.charAt(i) - '0']++;
            A += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(guessA[i], guessB[i]);
        }
        return A + "A" + (B - A) + "B";

    }
}