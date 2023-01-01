class Solution {

    public int[] closestPrimes(int left, int right) {
        int[] res = new int[2];


        int dis = Integer.MAX_VALUE;
        int last = -10000000;

        for (int i = left; i <= right; i++) {
            if (!isPrime(i)) continue;
//            System.out.println(i);
            if (i - last < dis) {
                dis = i - last;
                res[0] = last;
                res[1] = i;
            }
            last = i;
            if (dis == 1 || dis == 2) break;
        }
//        System.out.println();
        if (last == -10000000 || res[0] == -10000000 || res[1] == -10000000) return new int[]{-1, -1};
        return res;
    }


    boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        if (num == 3) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}