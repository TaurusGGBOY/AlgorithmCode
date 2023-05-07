import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] temp1 = new int[26];
    int[] temp2 = new int[26];
    int[] temp3 = new int[26];
    int flag = 0;
    int len = Integer.MAX_VALUE;
    Queue<String> queue = new LinkedList<>();
    licensePlate = licensePlate.toLowerCase();
    for (int i = 0; i < temp3.length; i++) {
      try {
        temp3[licensePlate.charAt(i) - 'a']++;
      } catch (Exception e) {
      }
    }

    for (String str : words) {
      str = str.toLowerCase();
      temp2 = new int[26];
      temp1 = new int[26];
      flag = 0;
      System.arraycopy(temp3, 0, temp1, 0, temp1.length);
      for (int i = 0; i < str.length(); i++) {
        temp2[str.charAt(i) - 'a']++;
      }
      for (int i = 0; i < 26; i++) {
        temp1[i] -= temp2[i];
        if (temp1[i] > 0) {
          flag = 1;
          break;
        }
      }
      if (flag == 0) {
        if (len > str.length()) {
          queue.clear();
          queue.add(str);
          len = str.length();
        }
      }
    }
    return queue.isEmpty() ? "" : queue.poll();
  }
}
