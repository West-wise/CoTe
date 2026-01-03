#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, T, P;
    vector<int> need;
    need.reserve(6);
    cin >> N;
    cin >> need[0] >> need[1] >> need[2] >> need[3] >> need[4] >> need[5];
    cin >> T >> P;

    int ans = 0;
    for (int i = 0; i<6; i++)
    {
        ans += ceil((double)need[i]/T);
    }
    cout << ans << '\n';
    cout << N/P << " " << N%P << endl;
    return 0;
}