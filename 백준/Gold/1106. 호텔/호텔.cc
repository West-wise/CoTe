#pragma GCC optimize("O3")
#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    constexpr int INF = 1'000'000'000;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int C, N, max_cus;
    cin >> C >> N;
    max_cus = C + 100;
    vector<int> dp(max_cus+1, INF); // 100이 최댓값임, 배열의 각 인덱스는 목표 인원을 나타냄
    dp[0] = 0;
    vector<pair<int,int>> info(N); // <인원, 비용>의 형태로 저장
    for (int i= 0; i<N; i++) cin >> info[i].second >> info[i].first;

    for (const auto& [man, cost] : info)
    {
        for (int k = 0; k+man<=max_cus; k++)
        {
            if (dp[k] == INF) continue;
            dp[man+k] = min(dp[man+k], dp[k] + cost);
            // show(dp);
        }
    }
    int ans = INF;
    for (int i=C; i<=max_cus; i++)
    {
        ans = min(ans, dp[i]);
    }
    cout << ans << endl;

    return 0;
}