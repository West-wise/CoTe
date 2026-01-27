#include <bits/stdc++.h>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    int N,S; cin>>N>>S;
    vector<int> arr(N);
    for (int i = 0; i<N; i++) cin >> arr[i];

    int left = 0, right = 0, sum = 0, ans = N+1;

    while (true)
    {
        if (sum >= S)
        {
            ans = min(ans, right - left);
            sum -= arr[left++];
        } else if (right == N) break;
        else
        {
            sum += arr[right++];
        }
    }
    if (ans == N+1) cout << 0;
    else cout << ans;
    return 0;
}