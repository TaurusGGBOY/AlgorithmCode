class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        int l = 0, r = 0;
        int min = Math.min(first.length(), second.length());
        int max = Math.max(first.length(), second.length());
        while (l < min && first.charAt(l) == second.charAt(l)) l++;
        while (min - r - 1 >= 0 && first.charAt(first.length() - r - 1) == second.charAt(second.length() - r - 1))
            r++;
        return Math.abs(max + 1 - r - l) <= 2;
    }
}