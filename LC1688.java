class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (!sequence.contains(sb.toString())) return i - 1;
            sb.append(word);
        }
        return 100;
    }
}