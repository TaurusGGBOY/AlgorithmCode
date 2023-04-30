#include <iostream>
#include <set>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> gardenNoAdj(int n, vector<vector<int>> &paths) {
    vector<int> inDegree(n + 1);
    set<int> zeroInDegree;
    vector<vector<int>> pathMap(n + 1);
    vector<vector<int>> choices(n + 1, vector<int>(5));

    for (auto &p : paths) {
      if (p[0] > p[1]) {
        auto temp = p[0];
        p[0] = p[1];
        p[1] = temp;
      }

      if (!inDegree[p[0]]) {
        zeroInDegree.insert(p[0]);
      }

      pathMap[p[0]].emplace_back(p[1]);
      if (++inDegree[p[1]]) {
        zeroInDegree.erase(p[1]);
      }
    }

    vector<int> res(n,1);
    while (!zeroInDegree.empty()) {
      int num = *(zeroInDegree.begin());
      zeroInDegree.erase(num);

      res[num - 1] = chooseColor(choices[num]);
      for (auto &n : pathMap[num]) {
        choices[n][res[num - 1]] = -1;
        inDegree[n]--;
        if (!inDegree[n]) {
          zeroInDegree.insert(n);
        }
      }
    }
    return res;
  }

  int chooseColor(vector<int> &colors) {
    for (int i = 1; i < colors.size(); i++) {
      if (colors[i] == -1)
        continue;
      return i;
    }
    return 1;
  }
};

// int main() {
//   Solution solution;
//   int n = 3;
//   vector<vector<int>> paths{
//       {1, 2},
//       {2, 3},
//       {3, 1},
//   };

//   auto res = solution.gardenNoAdj(n, paths);
//   for (int i = 0; i < res.size(); i++){
//     std::cout << res[i] << endl;      
//   }
// }

// int main() {
//   Solution solution;
//   int n = 4;
//   vector<vector<int>> paths{
//       {1, 2},
//       {3, 4},
//   };

//   auto res = solution.gardenNoAdj(n, paths);
//   for (int i = 0; i < res.size(); i++){
//     std::cout << res[i] << endl;      
//   }
// }

int main() {
  Solution solution;
  int n = 4;
  vector<vector<int>> paths{
      {1, 2},
      {2, 3},
      {3, 4},
      {4, 1},
      {1, 3},
      {2, 4},
  };

  auto res = solution.gardenNoAdj(n, paths);
  for (int i = 0; i < res.size(); i++){
    std::cout << res[i] << endl;      
  }
}