#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    ll N, ans = 0;
    cin >> N;
    vector<vector<ll>> arr(4, vector<ll>(N, 0));
    for (int i = 0; i<N; i++) {
        cin >> arr[0][i] >> arr[1][i] >> arr[2][i] >> arr[3][i];
    }
    for (auto& row : arr) {
        sort(row.begin(), row.end());
    }
    vector<vector<ll>> tmp_sum(2);
    tmp_sum[0].reserve(N*N); tmp_sum[1].reserve(N*N);

    for (int num = 0; num<2; num++) {
        for (int i = 0; i<N; i++) {
            for (int k = 0; k<N; k++) {
                tmp_sum[num].push_back(arr[num][i] + arr[num+2][k]);
            }
        }
        sort(tmp_sum[num].begin(), tmp_sum[num].end());
    }
    ll left = 0, right = N*N-1;
    while (left < (ll)tmp_sum[0].size() && right >= 0 ) {
        ll sum = tmp_sum[0][left] + tmp_sum[1][right];
        if (sum == 0) {
            ll cntA = 0, cntB = 0, a = tmp_sum[0][left], b = tmp_sum[1][right];
            while (left < (ll)tmp_sum[0].size() && tmp_sum[0][left] == a) {
                cntA++;
                left++;
            }
            while (right < (ll)tmp_sum[1].size() && tmp_sum[1][right] == b) {
                cntB++;
                right--;
            }

            ans += cntA * cntB;
        }
        else if (sum < 0) left++;
        else right--;
    }

    cout << ans;
    return 0;
}