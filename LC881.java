import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 1) {
            return 1;
        }
        Arrays.sort(people);
        int lastIndex = 0;
        for (; lastIndex < people.length; lastIndex++) {
            if (people[lastIndex] >= limit) {
                break;
            }
        }
        lastIndex--;
        if (lastIndex <= 0) {
            return people.length;
        }
        int res = people.length - lastIndex-1;
        int i = 0;
        int j = lastIndex;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                res++;
            }else{
                j--;
                res++;
            }
        }
        if (i == j) {
            res++;
        }
        return res;
    }
}