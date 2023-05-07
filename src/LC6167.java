class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] alpha = new int[26];
        int[] lastAppear = new int[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (alpha[pos] == 1) count[pos] = i - lastAppear[pos] - 1;
            lastAppear[pos] = i;
            alpha[pos] = 1;
        }
        for (int i = 0; i < distance.length; i++) {
            if(alpha[i] == 1 && distance[i]!=count[i] ) return false;
        }
        return true;
    }
}