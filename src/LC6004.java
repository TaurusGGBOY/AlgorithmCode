import java.util.Arrays;

class Solution {
    public int countOperations(int num1, int num2) {
        int[] temp = new int[]{num1, num2};
        int count = 0;
        while (temp[0] != 0 && temp[1] != 0) {
            count++;
            Arrays.sort(temp);
//            System.out.println(Arrays.toString(temp));
            temp[1] = temp[1] - temp[0];
        }
//        System.out.println();
        return count;
    }
}