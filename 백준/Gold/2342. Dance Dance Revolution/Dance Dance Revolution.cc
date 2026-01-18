#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int get_cost(int from, int to)
{
    if (from == 0) return 2;
    if (from == to) return 1;
    if (abs(from - to) == 2) return 4;
    return 3;
}
int dp[100001][5][5];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    int x;
    // dp[step][left][right]

    vector<int> command;
    while (cin >> x && x != 0) command.push_back(x);
    int n = (int)command.size();
    for (int i = 0; i <= n; i++)
        for (int l = 0; l < 5; l++)
            for (int r = 0; r < 5; r++)
                dp[i][l][r] = 4e6;

    dp[0][0][0] = 0;
    for (int i = 0; i<n; i++)
    {
        int target = command[i];
        for (int l = 0; l<5; l++)
        {
            for (int r = 0; r<5; r++)
            {
                if (dp[i][l][r] == 4e6) continue;
                if (target != r) dp[i + 1][target][r] = min(dp[i + 1][target][r], dp[i][l][r] + get_cost(l, target));
                if (target != l) dp[i + 1][l][target] = min(dp[i + 1][l][target], dp[i][l][r] + get_cost(r, target));
            }
        }
    }

    int ans = 4e6;
    for (int l = 0; l < 5; l++) {
        for (int r = 0; r < 5; r++) {
            ans = min(ans, dp[n][l][r]);
        }
    }
    cout << (ans == 4e6 ? 0 : ans);

    return 0;
}