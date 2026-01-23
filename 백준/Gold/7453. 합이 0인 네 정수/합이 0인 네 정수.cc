#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    ll ans = 0;
    cin >> N;

    vector<vector<ll>> arr(4, vector<ll>(N));

    for (int i = 0; i<N; i++) cin >> arr[0][i] >> arr[1][i] >> arr[2][i] >> arr[3][i];

    for (auto& v : arr) sort(v.begin(), v.end());

    vector<vector<ll>> sum(2);
    sum[0].reserve(N*N);
    sum[1].reserve(N*N);

    for (int num = 0; num < 2; num++)
    {
        for (int i = 0; i<N; i++)
        {
            for (int k = 0; k<N; k++)
            {
                sum[num].push_back(arr[num][i] + arr[num+2][k]);
            }
        }
    }
    sort(sum[0].begin(), sum[0].end());
    sort(sum[1].begin(), sum[1].end());

    ll limit = (ll)sum[0].size();
    ll left = 0, right = limit-1;
    while (left < limit && right >= 0)
    {
        ll sum_val = sum[0][left] + sum[1][right];
        if (sum_val == 0)
        {
            ll cntA=0, cntB=0;
            ll a = sum[0][left], b = sum[1][right];

            while (left < limit && sum[0][left] == a)
            {
                cntA++; left++;
            }
            while (right >= 0 && sum[1][right] == b)
            {
                cntB++; right--;
            }
            ans += cntA*cntB;
        }
        else if (sum_val < 0) left++;
        else right--;
    }
    cout << ans;

    return 0;
}