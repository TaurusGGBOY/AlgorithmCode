class Solution {
  public int[] fraction(int[] cont) {
    int[] result = new int[2];
    result[0] = cont[cont.length - 1];
    result[1] = 1;
    for (int i = cont.length - 2; i >= 0; i--) {
      int temp = result[0];
      result[0] = result[1];
      result[1] = temp;
      result[0] = cont[i] * result[1] + result[0];
    }
    return result;
  }
}
