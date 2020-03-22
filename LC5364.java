import java.util.Vector;

class Solution {
  public int[] createTargetArray(int[] nums, int[] index) {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < index.length; i++) {
      vector.insertElementAt(nums[i],index[i]);
    }
    int[] res = new int[index.length];
    for (int i = 0; i < index.length; i++) {
      res[i] = vector.get(i);
    }
    return res;
  }
}
