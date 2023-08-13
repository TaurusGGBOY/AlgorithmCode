#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
       vector<int> time(n);

        int curr = 0;
        for (auto& log : logs) {
            time[log[0]]  = max(log[1] - curr, time[log[0]]);
            curr = log[1];
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (time[i] > time[res]) {
                res = i;
            }
        }
        return res;
    }
};