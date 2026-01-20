#include <bits/stdc++.h>

using namespace std;
using ll = long long;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    string str1, str2, ans;
    cin >> str1;
    cin >> str2;
    int n = (int)str1.length(), m = (int)str2.length();
    vector<vector<int>> dp(n+1, vector<int>(m+1,0));
    for (int i = 1; i <= n; i++)
    {
        for (int k = 1; k<=m; k++)
        {
            if (str1[i-1] == str2[k-1])
            {
                dp[i][k] = dp[i-1][k-1]+1;
            } else
            {
                dp[i][k] = max(dp[i-1][k], dp[i][k-1]);
            }
        }
    }
    int lcs = dp[n][m];
    for (int i = n; i >= 1; i--)
    {
        for (int k = m; k >= 1; k--)
        {
            if (str1[i-1] == str2[k-1] && dp[i][k] == lcs)
            {
                ans += str2[k-1];
                lcs--;
                break;
            }
        }
    }
    cout << dp[n][m]<<"\n";
    if (dp[n][m] != 0)
    {
        reverse(ans.begin(), ans.end());
        cout << ans;
    }

    return 0;
}