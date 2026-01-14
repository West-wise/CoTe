#include <iostream>
#include <vector>

using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    cin >> N;
    vector<int> pos(1000001), ans(1000001);
    vector<int> card(N);
    for (int i=0; i<N; i++) {
        cin >> card[i];
        pos[card[i]] = 1;
    }
    for (int num : card)
    {
        for (int i = num; i<1000001; i+=num)
        {
            if (i == num) continue;
            if (pos[i] != 0)
            {
                ans[num]++; ans[i]--;
            }
        }
    }
    for (int i : card) cout << ans[i] << " ";
    return 0;
}