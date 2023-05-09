class Solution {
public:
    string baseNeg2(int n) {
        if (n == 0) return "0";
        string res;
        while (n != 0) {
            int remind = n & 1;
            res.push_back('0' + remind);
            n -= remind;
            n /= -2;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

// 1 -2 4 -8 16 -32 64