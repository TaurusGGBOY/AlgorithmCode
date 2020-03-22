class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    int[] orderArr = new int[26];
    for (int i = 0; i < order.length(); i++) {
      orderArr[order.charAt(i) - 'a'] = i;
    }
    boolean isLittle = false;
    for (int i = 0; i < words.length-1; i++) {
        isLittle = false;
        for(int j=0;j<words.length;j++)
        {
            if(orderArr[words[i].charAt(j)]-orderArr[words[i+1].charAt(j)]>0)
                return false;
            if(orderArr[words[i].charAt(j)]-orderArr[words[i+1].charAt(j)]<0)
            {
                isLittle=true;
                break;
            }
        }
      if (isLittle) continue;
      if(words[i].length()>words[i+1].length())
          return false;
    }
    return true;
  }
}
