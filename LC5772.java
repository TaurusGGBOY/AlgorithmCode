class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < firstWord.toCharArray().length; i++) {
            stringBuilder1.append(String.valueOf(firstWord.toCharArray()[i] - 'a'));
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < secondWord.toCharArray().length; i++) {
            stringBuilder2.append(String.valueOf(secondWord.toCharArray()[i] - 'a'));
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        for (int i = 0; i < targetWord.toCharArray().length; i++) {
            stringBuilder3.append(String.valueOf(targetWord.toCharArray()[i] - 'a'));
        }
        return Integer.parseInt(stringBuilder1.toString()) + Integer.parseInt(stringBuilder2.toString()) == Integer.parseInt(stringBuilder3.toString());
    }
}