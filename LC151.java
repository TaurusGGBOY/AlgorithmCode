class Solution {
  public String reverseWords(String s) {
    s = s.replaceAll("\\s+", " ");
    if (s.length() <= 0) return s;
    if (s.charAt(0) == ' ') s = s.substring(1);
    if (s.length() <= 0) return s;

    String[] strs = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=strs.length-1;i>=0;i--)
    {
      stringBuilder.append(strs[i]);
      stringBuilder.append(' ');
    }
    return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
  }
}
