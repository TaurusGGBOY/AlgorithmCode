class Solution {
    final static int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public int distinctPrimeFactors(int[] nums) {
        int[] temp = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            getNum(temp, nums[i]);
        }

        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) res++;
        }
//        for(int i = 0; i < 10;i++){
//            System.out.print(temp[i]+" ");
//        }
//        System.out.println();
        return res;
    }

    void getNum(int[] temp, int num) {
        for (int i = 0; i < prime.length; i++) {
            while (num % prime[i] == 0) {
                if (num == 0) break;
                temp[prime[i]]++;
                num /= prime[i];
            }
        }
        // 如果没有质因数
        if (num > 1) {
            temp[num]++;
        }
    }

}