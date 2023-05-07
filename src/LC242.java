class Solution {
  public boolean isAnagram(String s, String t) {
    int[] temp1 = new int[26];
    int[] temp2 = new int[26];
    for (int i = 0; i < s.length(); i++) {
      temp1[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      temp2[t.charAt(i) - 'a']++;
    }
      for (int i = 0; i < 26; i++) {
          if(temp1[i]!=temp2[i])
              return false;
      }
      return true;
  }
}
