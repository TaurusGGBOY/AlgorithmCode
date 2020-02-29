class Solution {
    int count = 0;

    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        else if (num % 2 == 0)
            return numberOfSteps(num / 2) + 1;
        else {
            return numberOfSteps(num - 1) + 1;
        }
    }
}