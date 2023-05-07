class Solution {
    public int repeatedStringMatch(String A, String B) {
        int num = B.length() / A.length()+2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            stringBuilder.append(A);
            if(stringBuilder.toString().contains(B))
                return i;
        }
        return -1;
    }
}