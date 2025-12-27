#include <iostream>
#include <deque>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    deque<char> ans;
    for (char c : number)
    {
        if (ans.empty())
        {
            ans.push_back(c);
            continue;
        }
        if ( k > 0)
        {
            while (ans.back() < c)
            {
                ans.pop_back();
                k--;
                if (ans.empty() || k <= 0) break;
            }
        }
        ans.push_back(c);
    }
    while (k != 0)
    {
        ans.pop_back();
        k--;
    }
    for (const char& c : ans)
    {
        answer+=c;
    }

    return answer;
}