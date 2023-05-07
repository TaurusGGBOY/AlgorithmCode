class Solution {
    public int minOperations(int n) {
        int count = 0;
//        System.out.println();
//        System.out.println(Integer.toBinaryString(n));

        while (n != 0) {
//            System.out.println(n);
            int temp = 0;
            int low = Integer.lowestOneBit(n);
            while (((low << temp) & n) != 0 && temp < 2) {
                temp++;
            }
            if (temp == 1) {
                n -= low;
            } else {
                n += low;
            }
            count++;
        }

        return count;
    }

}