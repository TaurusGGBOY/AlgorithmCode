class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        int base = a % mod;
        a = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            a = (a * pow(base, b[i], mod)) % mod;
            base = pow(base, 10, mod);
        }
        return a;
    }

    int pow(int a, int b, int mod) {
        if (b == 0) {
            return 1;
        }
        int base = a;
        a = 1;
        for (int i = 0; i < b; i++) {
            a = (a * base) % mod;
        }
        return a;
    }
}