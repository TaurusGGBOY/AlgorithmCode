class Solution {
    public int countVowelStrings(int n) {
        n=n+4;
        return n*(n-1)*(n-2)*(n-3)/24;
    }
}