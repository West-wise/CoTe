#include <iostream>
#include <vector>
#include <iomanip>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N, ans = 1e9;
    cin >> N;
    vector<vector<int>> cost(N, vector<int>(3,  1e9));

    for (int i = 0; i < N; i++) cin >> cost[i][0] >> cost[i][1] >> cost[i][2];

    for (int rgb = 0; rgb<3; rgb++) // 시작을 RGB중에 뭘로 하는지 결정하는 반복문
    {
        vector<vector<int>> dp(N, vector<int>(3, 1e9));
        dp[0][rgb] = cost[0][rgb];
        for (int k = 1; k<N; k++) // dp테이블 순회를 위한 반복문(총 2개)
        {
            dp[k][0] = cost[k][0] + min(dp[k-1][1], dp[k-1][2]);
            dp[k][1] = cost[k][1] + min(dp[k-1][0], dp[k-1][2]);
            dp[k][2] = cost[k][2] + min(dp[k-1][0], dp[k-1][1]);
        }
        for (int j = 0; j<3; j++)
        {
            if (rgb!= j) ans = min(ans, dp[N-1][j]);
        }
    }

    cout << ans << endl;

    return 0;
}