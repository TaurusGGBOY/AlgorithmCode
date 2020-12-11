import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        //筛法
        //首先2一下为0个
        if (n <= 2)
            return 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (!isPrime[i])
                continue;
            // 2 4 6 8
            // 3 6 9
            // 4
            // 5
            for (int j = 2; i * j < n; j++) {
                int pos = i * j;
//                if (n == 10)
//                    System.out.println(pos);
                if (!isPrime[pos])
                    continue;
                isPrime[pos] = false;
                count++;
//                if (n == 10)
//                    System.out.println(Arrays.toString(isPrime));
            }
        }
//        System.out.println("合数和1:" + count);
        return n - count - 2;
    }
}