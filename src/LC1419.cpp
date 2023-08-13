#include <string>
using namespace std;

class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        string str = "croak";
        int state = 4 ;
        vector<int> vec;
        vec.emplace_back(croakOfFrogs.back());
        for (int i = croakOfFrogs.size() - 1; i >= 0; i--) {
            char c = croakOfFrogs[i];
            
        }
    }
};