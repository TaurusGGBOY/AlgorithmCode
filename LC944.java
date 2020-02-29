// 不懂 不喜欢这道题
class Solution {
    public int minDeletionSize(String[] A) {
        int l = A.length;
        int n = A[0].length();
        ArrayList al = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    al.add(i);
                    break;
                }
            }

        }
        return al.size();
    }

}
