import java.util.*;

class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> gcds = new HashSet<>();

        for (int num : nums) {
            gcds.add(num);
        }
        int gcdsize = gcds.size();
        // n三方
        Set<Integer> tempSet = new HashSet<>(gcds);

        for (int i = 0; i < gcdsize; i++) {
            // dosomething
            Set<Integer> newSet = new HashSet<>(tempSet);
            tempSet.clear();
            for (int gcd1 : newSet) {
                for (int gcd2 : gcds) {
                    int temp = gcd(gcd1, gcd2);
                    if (!gcds.contains(temp)) {
                        tempSet.add(temp);
                    }
                }
            }
            if (tempSet.isEmpty()) {
                break;
            }
            gcds.addAll(tempSet);
        }
        return gcds.size();
    }

    int gcd(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        while (num1 - num2 != num2) {
            int temp = num1 - num2;
            if (temp > num2) {
                num1 = temp;
            } else {
                num1 = num2;
                num2 = temp;
            }
        }
        return num2;
    }
}