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
    int i = n, j = m;
    while (i > 0 && j > 0) {
        if (str1[i-1] == str2[j-1]) {
            ans.push_back(str1[i-1]);
            i--; j--;
        } else if (dp[i-1][j] >= dp[i][j-1]) {
            i--;
        } else {
            j--;
        }
    }
    cout << dp[n][m]<<"\n";
    reverse(ans.begin(), ans.end());
    if (dp[n][m] != 0) cout << ans;
    return 0;
}