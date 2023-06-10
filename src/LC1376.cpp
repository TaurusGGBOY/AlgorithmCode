#include "vector"
#include "algorithm"

using namespace std;

class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        int res = 0;
        vector<int> vis(n, -1);
        vis[headID] = 0;

        function<void(int)> dfs = [&](int id) -> void {
          if (vis[id] != -1) {
            return;
          }
          int m = manager[id];
          dfs(m);
          vis[id] = vis[m] + informTime[m];
        };

        for (auto i = 0; i < n; i++) {
          dfs(i);
          res = max(vis[i], res);
        }
        return res;
    }

    // void dfs(int n, int headID, vector<int>& manager, vector<int>& informTime, vector<int>& vis, int id) {
        
    // }
};