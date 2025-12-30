#include <iostream>
#include <string>
#include <cmath>
#include <vector>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int M,N;
    cin >> M >> N;
    vector<bool> ans(N+1, false);
    ans[1] = true;
    int limit = static_cast<int>(sqrt(N));
    for (int i = 2; i<=limit; i++)
    {
        if (!ans[i])
        {
            for (int k = i*i; k<=N; k+=i)
            {
                ans[k] = true;
            }
        }
    }
    for (int i = M; i<=N; i++)
    {
        if (!ans[i]) cout << i << '\n';
    }
}