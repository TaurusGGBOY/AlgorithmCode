class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        int res = 0;
        unordered_set<int> hashSet;
        for (int x : nums) {
            if (hashSet.count(x - diff) && hashSet.count(x - diff * 2)) {
                res++;
            }
            hashSet.emplace(x);
        }
        return res;
    }
};