import java.util.Arrays;

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = Arrays.stream(energy).sum();
        int min = initialExperience - experience[0];
        for (int i = 0; i < experience.length; i++) {
            min = Math.min(min, initialExperience - experience[i]);
            initialExperience += experience[i];
        }
        int disEner = Math.max(sum - initialEnergy + 1, 0);
        int disExp = Math.max(-min + 1, 0);
        return disEner + disExp;
    }
}