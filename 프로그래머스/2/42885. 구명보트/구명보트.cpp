#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int answer = 0;

    sort(people.begin(), people.end());
    int start = 0;
    int end = static_cast<int>(people.size()-1);

    while (start <= end)
    {
        if (people.at(start) + people.at(end) <= limit)
        {
            start++;
        }
        end--;
        answer++;
    }
    cout << answer << "\n";

    return answer;
}