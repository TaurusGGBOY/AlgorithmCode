class Solution {
  public String reverseStr(String s, int k) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length() / (2 * k); i++) {
      stringBuilder.append(reverse(s.substring(i * 2 * k, (i + 1) * 2 * k - k)));
      stringBuilder.append((s.substring((i + 1) * 2 * k - k, (i + 1) * 2 * k)));
    }
    int remind = s.length() - (s.length() / (2 * k)) * (2 * k);
    if (remind <= k) {
      stringBuilder.append(reverse(s.substring(s.length() - remind, s.length())));
    } else {
      stringBuilder.append(reverse(s.substring(s.length() - remind, s.length() - remind + k)));
      stringBuilder.append(s.substring(s.length() - remind + k, s.length()));
    }
    return stringBuilder.toString();
  }

  public String reverse(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      stringBuilder.append(s.charAt(i));
    }
    return stringBuilder.toString();
  }
}
