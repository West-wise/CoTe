#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

using ll = long long;

int main() {

    int N;
    cin >> N;
    vector<int> liquid(N);
    for (int i = 0; i < N; i++) cin >> liquid[i];
    sort(liquid.begin(), liquid.end());
    vector<ll> ans(3);
    ll diff = 4e9;
    for (int i = 0; i < N-2; i++)
    {
        int left = i+1, right = N-1;
        while (left < right)
        {
            ll cur_sum = (ll)liquid[left] + liquid[i] + liquid[right];
            ll cur_diff = abs(cur_sum);
            if (cur_diff < diff)
            {
                diff = cur_diff;
                ans[0] = liquid[i];
                ans[1] = liquid[left];
                ans[2] = liquid[right];
                if (cur_sum == 0) break;
            }
            if (cur_sum < 0) left++;
            else if (cur_sum > 0) right--;
        }
        if (diff == 0) break;
    }
    sort(ans.begin(), ans.end());
    cout << ans[0] << " " << ans[1] << " " << ans[2] << endl;
    return 0;
}