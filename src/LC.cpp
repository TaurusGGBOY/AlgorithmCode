#include<set>
#include<vector>
#include<map>
using namespace std;

class LC {
   public:
   
   int countCompleteComponets(int n, vector<vector<int>>& edges) {
    int ans = 0;
    vector<set<int>> m(n+1, set<int>());
    for (int i = 0; i< n;i++) {
        m[i].insert(i);
    }
    for(auto x:edges) {
        m[x[0]].insert(x[1]);
        m[x[1]].insert(x[0]);
    }
    map<set<int>, int> s;
    for (int i = 0; i < n; i++) {
        s[m[i]]++;
    }
    for (auto& p : s) {
        if(p.second==p.first.size()) {
            ans++;
        }
    }
    return ans;
   }
};