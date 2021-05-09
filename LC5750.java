class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - 1950]++;
            }
        }
        int people = 0;
        int year = 2050;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > people) {
                year = i + 1950;
                people = years[i];
            }
        }
        return year;
    }
}