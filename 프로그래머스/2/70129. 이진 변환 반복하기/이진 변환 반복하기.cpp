#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

string to_binary(int n)
{
    if (n == 0) return "0";
    string ans="";
    auto num = static_cast<unsigned int>(n);
    while (num > 0)
    {
        ans += (num & 1) ? '1' : '0';
        num >>= 1;
    }
    reverse(ans.begin(), ans.end());
    return ans;
}

vector<int> solution(string s) {
    vector<int> answer;
    int counting = 0;
    int zero = 0;

    while (s != "1")
    {
        counting++;
        int zcnt = count(s.begin(), s.end(), '0');
        zero += zcnt;
        s = to_binary(s.length() - zcnt);
    }
    return {counting, zero};
}