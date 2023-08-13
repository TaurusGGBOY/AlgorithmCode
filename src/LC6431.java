class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int prev = 0;
        for (int i = 0; i < derived.length; i++) {
            prev = derived[i] ^ prev;
        }
        if (prev == 0) return true;

         prev = 1;
        for (int i = 0; i < derived.length; i++) {
            prev = derived[i] ^ prev;
        }
        if (prev == 1) return true;

        return false;
    }
}