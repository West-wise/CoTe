#include <bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;
using ll = long long;
int main() {
    int T = 10, cnt = 1;
    constexpr int side[] = {-2,-1,1,2};
    while (T--)
    {
        int N, ans = 0; cin >> N;
        if (N == 4)
        {
            cout << "#" << cnt++ << " " << 0 << "\n";
            continue;
        }
        vector<int> arr(N);
        for (int i = 0; i < N; i++) cin >> arr[i];
        for (int i = 2; i<N-2; i++)
        {
            int high = arr[i];
            int tmp = high;
            // 주변 2칸 이내 건물보다 일단 높아야함
            if (arr[i-2] < high && arr[i-1] < high && arr[i+1] < high && arr[i+2] < high)
            {
                for (int dist : side)
                {
                    tmp = min(tmp, high - arr[i + dist]);
                }
                ans += tmp;
            }
        }
        cout << "#" << cnt++ << " " << ans << "\n";
    }
    return 0;
}