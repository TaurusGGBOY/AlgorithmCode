class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) count++;
        }
        return (int) (count * 100.0f / s.length());
    }
}