class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        int[] count = new int[26];
        for (char c : chars) {
            count[c - 'a']++;
        }
        char[] chars1 = ransomNote.toCharArray();
        for (char c : chars1) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}