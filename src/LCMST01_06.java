import java.util.Arrays;

class Solution {
  public String compressString(String S) {
    if(S.length()==0)
      return S;
    char[] sarr = S.toCharArray();
    char last = sarr[0];
    int count=1;
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=1;i<sarr.length;i++)
    {
      if(sarr[i]==last)
      {
        count++;
      }
      else
      {
        stringBuilder.append(last);
        stringBuilder.append(count);
        last= sarr[i];
        count=1;
      }
    }
    stringBuilder.append(last);
    stringBuilder.append(count);
    return stringBuilder.length() >= S.length() ? S : stringBuilder.toString();
  }
}