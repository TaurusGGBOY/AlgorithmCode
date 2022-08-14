import java.util.Arrays;

class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int r = 1;
        int res = 1;
        int sum = grades[0];
        while (r < grades.length) {
            int temp = 0;
            int size = 0;
            while (r < grades.length && (size <= res || temp <= sum)) {
                temp += grades[r++];
                size++;
            }
            if (size <= res || temp <= sum) res--;
            sum = temp;
            res++;
        }
        return res;
    }
}

// 3 5 6 7 10 12
// 2
// [47,2,16,17,41,4,38,23,47]
// 2
// 16 17
// 23 38 41
//