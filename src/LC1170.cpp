#include "vector"
#include "string"

using namespace std;

class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        vector<int> counter(2001);
        vector<int> subfix(2001);

        for (auto& w : words) {
            int count = f(w);
            counter[count]++;
        }

        for (int i = static_cast<int>(counter.size()) - 2; i >= 0; --i) {
            subfix[i] = counter[i + 1] +subfix[i + 1] ;
        }

        vector<int> res(queries.size());

        for (auto i = 0; i < queries.size(); i++) {
            int count = f(queries[i]);
            res[i] = subfix[count];
        }
        return res;
    }

    int f(const string& w) {
        char c = 'z';
        int count = 0;
        for (auto& ch : w) {
            if (ch < c) {
                c = ch;
                count = 1;
            } else if (ch == c) {
                count++;
            }
        }
        return count;
    }
};