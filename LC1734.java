class Solution {
    public int[] decode(int[] encoded) {
        //encode[i-1] XOR encode[i] = perm[i-1]XORperm[i+1]
        // encode[0] = perm[0] XOR perm[1]
        // perm[0] XOR encode[0] = perm[1]
        //encode[odd] = perm[odd] XOR perm[odd+1]
        // encode[even] = perm[even] XOR perm[even+1]
        // 如果是奇数个 encode[odd] XOR encode[even] = perm[even+1]
        // 1+2+3+4+5+...+
        //
        // 如果是偶数个 encode[odd] XOR encode[even] = perm[odd+1]
        // 0+1+2+3+4+...+
        // 0 ^ len-1
        int odd = 0;
        int total = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            total ^= i;
        }
        for (int i = 0; i < encoded.length; i++) {
            if (i % 2 == 1) {
                odd ^= encoded[i];
            }
        }
        int[] res = new int[encoded.length + 1];
        res[0] = odd ^ total;
        for (int i = 1; i < res.length; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }
}