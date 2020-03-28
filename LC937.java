// Ê§°Ü
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return 0;
      }
    });
  }

}