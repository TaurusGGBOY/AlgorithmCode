class Solution {
    public int findNthDigit(int n) {
        // 9 90*2 900*3 9000*4 90000*5
        //10
        if (n < 10) {
            return n;
        }
        long temp = 9;
        long len = 1;
        long sum = 9;
        for (; sum < n; sum += temp * len) {
            temp *= 10;
            len++;
        }
        sum -= temp * len;
        long remind = n - sum;
        long div = (remind - 1) / len;
        long mod = (remind - 1) % len;
//        System.out.println(remind+" "+div+" "+mod);
//        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 0; i < len - 1; i++) {
            sb.append('0');
        }
        long start = Long.parseLong(sb.toString());
        long num = start + div;
        String s = String.valueOf(num);
        return s.charAt((int)mod) - '0';
    }
}