#include <iostream>
#include <vector>

using namespace std;
using pi = pair<int, int>;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    constexpr int INF = 10000*10000;
    int C, N;
    cin >> C >> N;
    int max_city = C+100;
    vector<int> dp(max_city+1, INF); dp[0] = 0;
    vector<pi> info(N);
    for (auto& [man, cost] : info) cin >> cost >> man;

    for (const auto&[man, cost] : info) {
        for (int i = 0; i+man<=max_city; i++) {
            if (dp[i] == INF) continue;
            dp[i+man] = min(dp[i+man], dp[i] + cost);
        }
    }
    int ans = INF;
    for (int i = C; i<=max_city; i++) {
        ans = min(ans, dp[i]);
    }
    cout << ans;

    return 0;
}