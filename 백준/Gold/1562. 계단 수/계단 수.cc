#include <bits/stdc++.h>
using namespace std;
using ll = long long;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    static constexpr int MOD = 1'000'000'000;
    int N; cin >> N;
    ll dp[N+1][10][1024]; // dp[길이][끝자리][사용한 숫자집합]
    for (int i = 1; i<=N; i++)
        for (int j = 0; j<10; j++)
            for (int k = 0; k<1024; k++)
                dp[i][j][k] = 0;
    for (int i = 1; i<10; i++)
    {
        dp[1][i][1<<i] = 1;
    }

    for (int len = 1; len <N; len++)
    {
        for (int digit = 0; digit < 10; digit++)
        {
            for (int mask = 0; mask < 1024; mask++)
            {
                ll cur = dp[len][digit][mask];
                if (cur == 0) continue;
                if (digit >0)
                {
                    int next = digit - 1;
                    int newMask = mask | (1<<next);
                    dp[len+1][next][newMask] = (dp[len+1][next][newMask] + cur) % MOD;
                }
                if (digit < 9)
                {
                    int next = digit + 1;
                    int newMask = mask | (1<<next);
                    dp[len+1][next][newMask] = (dp[len+1][next][newMask] + cur) % MOD;
                }
            }
        }
    }
    ll ans = 0;
    for (int i = 0; i<10; i++)
    {
        ans = (ans + dp[N][i][1023]) % MOD;
    }
    cout << ans;
    return 0;
}