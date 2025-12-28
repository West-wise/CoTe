#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    vector<pair<int, int>> meeting;
    for (int i  = 0; i < N; i++)
    {
        int start, end;
        cin >> start >> end;
        meeting.emplace_back(start, end);
    }
    sort(meeting.begin(), meeting.end(),
        [](const pair<int, int>& a, const pair<int, int>& b)
    {
        if (a.second != b.second) return a.second < b.second;
        return a.first < b.first;
    });
    int answer = 0;
    int start = 0;
    for (const auto& p: meeting)
    {
        if (start <= p.first)
        {
            answer++;
            start = p.second;
        }
    }
    cout << answer << "\n";
}