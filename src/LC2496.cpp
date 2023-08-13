#include <string>
class Solution {
public:
    int maximumValue(vector<string>& strs) {
        int res = 0;
        for (auto& s : strs) {
            bool flag = true;
            for (auto i = 0; i < s.size(); ++i) {
                if (s[i] < '0' || s[i] > '9') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res = max(res, std::stoi(s));
            } else {
                res = max(res, static_cast<int>(s.size()));
            }
        }
        return res;
    }
};