import java.util.Arrays;

class Solution {
  public int minIncrementForUnique(int[] A) {
    Arrays.sort(A);
    int sum = 0;
    for (int i = 0; i < A.length - 1; i++) {
      sum += A[i + 1] <= A[i] ? A[i] + 1 - A[i + 1] : 0;
      A[i + 1] = A[i + 1] <= A[i] ? A[i] + 1 : A[i + 1];
    }
    return sum;
  }
}
