#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    cin >> N;
    vector<pair<int,int>> matrix(N);
    vector<int> r(N+1), c(N+1);
    // [5,3] [3,2] [2,6]
    for (int i = 1; i <= N; i++) cin >> r[i] >> c[i];
    ll dp[N+2][N+2];
    for (int i = 0; i <= N; i++)
    {
        for (int j = 0; j <= N; j++)
        {
            dp[i][j] = LLONG_MAX;
        }
        dp[i][i] = 0;
    }

    // 행렬곱의 조건이 N * M , M * K 를 곱할때는 M이 같아야 하는 조건이 있기 때문에...
    for (int len=2; len <= N; len++)
    {
        for (int i = 1; i+len-1<=N; i++)
        {
            int j = i+len-1;
            for (int k = i; k<j; k++)
            {
                ll cost = dp[i][k] + dp[k+1][j] +(ll)r[i] * c[k] * c[j];
                dp[i][j] = min(dp[i][j], cost);
            }
        }
    }

    cout << dp[1][N];

    return 0;
}