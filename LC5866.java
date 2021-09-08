import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public boolean gcdSort(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a <= b || gcd(a, b) <= 1) {
                    return 0;
                }
                return 1;
            }
        });
        System.out.println(arr.toString());

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }


}