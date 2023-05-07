class Solution {
  public boolean canPermutePalindrome(String s) {
    int[] alphas = new int[128];
    for (int i = 0; i < s.length(); i++) alphas[s.charAt(i)]++;

    int ji = 0;
    for (int i = 0; i < 128; i++) {
      ji += alphas[i] % 2 == 1 ? 1 : 0;
    }
    return ji <= 1;
  }
}
