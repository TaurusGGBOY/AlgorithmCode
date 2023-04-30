#include "algorithm"
#include "iostream"
#include "vector"


using namespace std;

class Solution {
public:
  vector<int> numMovesStones(int a, int b, int c) {
    int nums[3] = {a, b, c};
    sort(nums, nums + 3);
    // for (int const &i: nums) {
    //     cout << i << ' ';
    // }

    vector<int> res(2, 0);
    if (nums[0] + 2 == nums[1] || nums[1] + 2 == nums[2]) {
        res[0] = 1;
    } else {
      res[0] += nums[0] + 1 == nums[1] ? 0 : 1;
      res[0] += nums[1] + 1 == nums[2] ? 0 : 1;
    }

    res[1] += nums[1] - nums[0] - 1;
    res[1] += nums[2] - nums[1] - 1;
    return res;
  }
};