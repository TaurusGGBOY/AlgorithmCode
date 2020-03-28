// Ê§°Ü
class Solution {
  public int minimumLengthEncoding(String[] words) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(words[0]);
    int[] temp = new int[words.length];
    temp[0] = 0;
    String tStr;
    for (int i = 1; i < words.length; i++) {
      tStr = stringBuilder.toString();
      if (tStr.endsWith(words[i])) {
        temp[i] = tStr.lastIndexOf(words[i]);
      } else {
        temp[i] = tStr.length() + 1;
        stringBuilder.append("#");
        stringBuilder.append(words[i]);
      }
    }
    return stringBuilder.length()+1;
  }
}
