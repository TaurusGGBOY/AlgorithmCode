#include "vector"
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        vector<vector<int>> res;

        int two = 0;
        int sum = 0;
        for (auto i = 0; i < colsum.size(); ++i) {
            if (colsum[i] = 2 ) {
                ++two;
            }
            sum += colsum[i];
        }

        if (sum != upper + lower || two > min(upper, lower)) {
            return res;
        }

        upper -= two;
        lower -= two;

        for (auto i = 0; i < colsum.size(); ++i) {
            if (colsum[i] == 2) {
                res[i][0] = 1;
                res[i][1] = 1;
            } else if (colsum[i] == 1){
                res[i][0] = upper > 0 ? 1 : 0;
                res[i][1] = !res[i][0];
                upper -= res[i][0];
                lower -= res[i][1];
            }
        }

        return res;
    }
};