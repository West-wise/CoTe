#include <set>
#include <unordered_set>
#include <vector>
#include <algorithm> 
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    // sort(lost.begin(), lost.end());
    // sort(reserve.begin(), reserve.end());
    unordered_set<int> need;
    set<int> extra;
    for (const int& i : reserve) extra.insert(i);
    for (const int& i : lost)
    {
        if (extra.find(i) != extra.end()) extra.erase(i);
        else need.insert(i);
    }
    int answer = n - static_cast<int>(need.size());
    for (const int& i : extra)
    {
        if (need.find(i-1) != need.end())
        {
            answer++;
            need.erase(i-1);
        } else if (need.find(i+1) != need.end())
        {
            answer++;
            need.erase(i+1);
        }
    }

    return answer;
}