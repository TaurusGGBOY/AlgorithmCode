class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) target = 'a';
        else target = (char) (target + 1);
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] < target) l = m + 1;
            else if (letters[m] > target) r = m;
            else return letters[m];
        }
        return letters[l];
    }
}