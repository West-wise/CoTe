#include <iostream>
#include <map>
#include <vector>

using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int T,N,M;
    long long ans = 0;
    cin >> T;
    cin >> N;
    vector<int> arrA(N);
    for (int i = 0; i<N; i++) cin >> arrA[i];
    cin >> M;
    vector<int> arrB(M);
    for (int i = 0; i<M; i++) cin >> arrB[i];

    map<ll,ll> mapA,mapB;

    for (int i = 0; i<N; i++)
    {
        int tmp = 0;
        for (int k = i; k<N; k++)
        {
            tmp += arrA[k];
            mapA[tmp]++;
        }
    }
    for (int i = 0; i<M; i++)
    {
        int tmp = 0;
        for (int k = i; k<M; k++)
        {
            tmp += arrB[k];
            mapB[tmp]++;
        }
    }
    for (const auto& [Ka,Va] : mapA)
    {
        auto it = mapB.find(T - Ka);
        if (it != mapB.end()) ans += Va * (it->second);
    }
    cout <<ans;
    return 0;
}