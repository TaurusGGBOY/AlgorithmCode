class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return a.length() <= 1 || a.charAt(0) == b.charAt(b.length() - 1) || b.charAt(0) == a.charAt(a.length() - 1);
    }
}