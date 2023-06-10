class Solution {
public:
    int storeWater(vector<int>& bucket, vector<int>& vat) {
        int res = 0;
        for (int i = 0; i < bucket.size(); i++) {
            int dis = 0;
            int time = 0;
            if (bucket[i] % vat[i] > 0) {
                dis = vat[i] - (bucket[i] % vat[i]);
                time += dis;
            }
            time += (bucket[i] + dis) / vat[i];
            res = max(time, res);
        }
        return res;
    }
};