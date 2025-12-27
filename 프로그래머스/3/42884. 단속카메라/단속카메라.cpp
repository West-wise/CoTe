#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#include <unordered_set>
using namespace std;

int solution(vector<vector<int>> routes) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int answer = 0;
    int lastPos = -30001;
    sort(routes.begin(), routes.end(), [&](const vector<int> &a, const vector<int> &b)
    {
        return a[1] < b[1];
    });

    for (auto route : routes)
    {
        if (lastPos < route[0])
        {
            lastPos = route[1];
            answer++;
        }
    }
    return answer;
}