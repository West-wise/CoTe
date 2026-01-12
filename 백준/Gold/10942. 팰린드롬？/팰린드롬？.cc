#include <iostream>
#include <vector>
using namespace std;
void pre_build_dp(vector<vector<bool>>& dp, const vector<int>& arr) // dp는 재활용이 중요하다.....
{
    int n = arr.size();

    for (int i = 0; i<n; i++) dp[i][i] = true;

    for (int i = 0; i<n-1; i++)
    {
        if (arr[i] == arr[i+1]) dp[i][i+1] = true;
    }

    for (int len = 3; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1; // 끝 인덱스
            if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N,M;
    cin >> N;
    vector<int> arr(N);
    vector<vector<bool>> dp(N, vector<bool>(N,false));
    for (int i = 0; i<N; i++)
    {
        cin >> arr[i];
    }
    cin >> M;
    pre_build_dp(dp, arr);
    for (int i = 0; i<M; i++)
    {
        int S,E;
        cin >> S >> E;
        cout << (dp[S-1][E-1] ? 1:0) << "\n";
    }
    return 0;
}