class Solution {

  public String toGoatLatin(String S) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] sArr = S.split(" ");
    for (int i = 0; i < sArr.length; i++) {
      String str = sArr[i];
      if (str.startsWith("a")
          || str.startsWith("e")
          || str.startsWith("i")
          || str.startsWith("o")
          || str.startsWith("u")
          || str.startsWith("A")
          || str.startsWith("E")
          || str.startsWith("I")
          || str.startsWith("O")
          || str.startsWith("U")) {
        stringBuilder.append(str);
      } else {
        try {
          stringBuilder.append(str.substring(1));
        } catch (Exception e) {
        }
        stringBuilder.append(str.charAt(0));
      }
      stringBuilder.append("ma");
      for (int j = 0; j < i + 1; j++) {
        stringBuilder.append('a');
      }
      stringBuilder.append(" ");
    }
    return stringBuilder.toString().trim();
  }
}
