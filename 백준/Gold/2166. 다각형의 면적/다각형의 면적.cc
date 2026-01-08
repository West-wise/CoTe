#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

using ll = long long;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N;
    cin >> N;
    vector<pair<ll,ll>> dots(N);
    ll tmp1=0,tmp2=0;
    for (int i = 0; i<N; i++) cin >> dots[i].first >> dots[i].second;

    for (int i = 0; i<N; i++)
    {
        int next = (i+1) %N;
        tmp1 += (dots.at(i).first * dots.at(next).second);
        tmp2 += (dots.at(next).first * dots.at(i).second);
    }
    ll res = abs(tmp1 - tmp2);
    cout << fixed << setprecision(1) << (double)res / 2.0 << endl;
    return 0;
}