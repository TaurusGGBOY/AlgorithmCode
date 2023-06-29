#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int calculate_similarity(const string& s1, const string& s2) {
   vector<vector<int>> dp;
  
}

int main() {
    int total_tests;
    cin >> total_tests;

    for (int i = 0; i < total_tests; i++) {
        int n;
        string s1, s2;
        cin >> n >> s1 >> s2;

        int max_similarity = calculate_similarity(s1, s2);
        cout << max_similarity << endl;
    }

    return 0;
}