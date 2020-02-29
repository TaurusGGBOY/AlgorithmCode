import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        Comparator cmp = new Cmp();
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp, cmp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    class Cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String os1 = Integer.toBinaryString(o1);
            String os2 = Integer.toBinaryString(o2);
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < os1.length(); i++) {
                count1 += os1.charAt(i) == '1' ? 1 : 0;
            }
            for (int j = 0; j < os2.length(); j++) {
                count2 += os2.charAt(j) == '1' ? 1 : 0;
            }
            return count1 != count2 ? (count1 - count2) : (o1 - o2);
        }
    }

}