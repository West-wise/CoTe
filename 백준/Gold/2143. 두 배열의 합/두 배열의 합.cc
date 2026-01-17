#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    ll T;
    int N, M;
    cin >> T;

    cin >> N;
    vector<ll> arrA(N);
    for (int i = 0; i < N; i++) cin >> arrA[i];

    cin >> M;
    vector<ll> arrB(M);
    for (int i = 0; i < M; i++) cin >> arrB[i];

    // === 부분합 저장용 벡터 ===
    vector<ll> SA, SB;

    // [수정/최적화] 정확한 개수만큼 reserve → 재할당 방지
    SA.reserve((ll)N * (N + 1) / 2);
    SB.reserve((ll)M * (M + 1) / 2);

    // === A의 모든 연속 부분합 ===
    for (int i = 0; i < N; i++) {
        ll sum = 0;               // [수정] int → ll (오버플로우 방지)
        for (int j = i; j < N; j++) {
            sum += arrA[j];
            SA.push_back(sum);
        }
    }

    // === B의 모든 연속 부분합 ===
    for (int i = 0; i < M; i++) {
        ll sum = 0;               // [수정] int → ll
        for (int j = i; j < M; j++) {
            sum += arrB[j];
            SB.push_back(sum);
        }
    }

    // === B 부분합 정렬 ===
    sort(SB.begin(), SB.end());

    ll ans = 0;

    // === 핵심: 이분 탐색으로 개수 계산 ===
    for (size_t i = 0; i < SA.size(); i++) {
        ll need = T - SA[i];

        auto low = lower_bound(SB.begin(), SB.end(), need);
        auto high = upper_bound(SB.begin(), SB.end(), need);

        ans += (high - low);   // [핵심] 동일 값 개수를 한 번에 누적
    }

    cout << ans;
    return 0;
}
