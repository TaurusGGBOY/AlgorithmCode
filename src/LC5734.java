class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] cstr = new int[26];
        for (char c : sentence.toCharArray()) {
            cstr[c - 'a']++;
        }
        for (int c : cstr) {
            if (c <= 0) {
                return false;
            }
        }
        return true;
    }
}