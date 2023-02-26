class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            counter1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            counter2[word2.charAt(i) - 'a']++;
        }


        for (int i = 0; i < counter1.length; i++) {
            if (counter1[i] <= 0) continue;
            counter1[i]--;
            counter2[i]++;
            for (int j = 0; j < counter2.length; j++) {
                if (counter2[j] <= 0) continue;
                if (counter2[j] == 1 && i == j) continue;
                counter1[j]++;
                counter2[j]--;
                int sum1 = 0;
                int sum2 = 0;

                for (int k = 0; k < counter1.length; k++) {
                    if (counter1[k] > 0) sum1++;
                    if (counter2[k] > 0) sum2++;
                }
                if (sum1 == sum2) return true;
                counter1[j]--;
                counter2[j]++;
            }
            counter1[i]++;
            counter2[i]--;
        }
        return false;
    }

}