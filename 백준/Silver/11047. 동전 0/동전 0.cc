#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, K;
    cin >> N >> K;
    vector<int> coin;
    for (int i = 0; i < N; i++)
    {
        int value;
        cin >> value;
        if (value <= K) coin.push_back(value);
    }
    int answer = 0;
    for (int i = coin.size() -1; i>=0; i--)
    {
        int val = coin[i];
        if (K/val >= 1)
        {
            answer += K/val;
            K %= val;
        }
        if (K == 0) break;
    }
    cout << answer << endl;
}