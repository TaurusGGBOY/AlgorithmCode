class Solution {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int[] res = new int[A.length];
    int sum = 0;
    for (int num : A) {
      sum += num % 2 == 0 ? num : 0;
    }
    for (int i = 0; i < queries.length; i++) {
        sum-=A[queries[i][1]]%2==0?A[queries[i][1]]:0;
        A[queries[i][1]]+=queries[i][0];
        sum+=A[queries[i][1]] % 2 == 0 ? A[queries[i][1]] : 0;
        res[i]=sum;
    }
    return res;
  }
}
