// TODO 失败
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] str1 = String.valueOf(o1).toCharArray();
                char[] str2 = String.valueOf(o2).toCharArray();
                for (int i = 0; i < Math.min(str1.length, str2.length); i++) {
                    if (str1[i] > str2[i]) {
                        return -1;
                    } else if (str1[i] < str2[i]) {
                        return 1;
                    }
                }
                // 222 222100 222199 2222 2223 2224
                // 432 4321 432
                //
                if (str1.length > str2.length) {
                    return 1;
                } else if (str1.length < str2.length) {
                    return -1;
                }

                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer anInt : ints) {
            stringBuilder.append(anInt);
        }
        return stringBuilder.toString();

    }
}