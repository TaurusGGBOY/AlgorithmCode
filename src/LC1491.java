class Solution {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            sum += salary[i];
            max = Math.max(salary[i], max);
            min = Math.min(salary[i], min);
        }
        return (double) ((sum-max-min)*1.0f)/(salary.length-2);
    }
}