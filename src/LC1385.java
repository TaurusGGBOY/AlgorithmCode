class Solution {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int times = 0;
    boolean flag;
    for (int i = 0; i < arr1.length; i++) {
      flag = false;
      for (int j = 0; j < arr2.length; j++) {
        if (Math.abs(arr1[i] - arr2[j]) <= d) {
          flag = true;
          break;
        }
      }
      if (!flag) times++;
    }
    return times;
  }
}
