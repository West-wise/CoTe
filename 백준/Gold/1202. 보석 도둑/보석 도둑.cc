#include <bits/stdc++.h>

using namespace std;
using ll = long long;
struct Jewel {
    int weight;
    int cost;
    Jewel(const int w, const int c) : weight(w), cost(c) {}
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N,K;
    ll ans = 0;
    cin >> N >> K;
    vector<int> max_weight(K);
    vector<Jewel> jewels; jewels.reserve(N);
    for(int i = 0; i<N; i++){
        int w,c;
        cin >> w >> c;
        jewels.emplace_back(w,c);
    }
    sort(jewels.begin(), jewels.end(), [](const Jewel& a, const Jewel& b) {
        return a.weight < b.weight;
    });
    for(int i =0; i<K; i++){
        cin >> max_weight[i];
    }
    sort(max_weight.begin(), max_weight.end());

    priority_queue<int> pq;

    size_t idx = 0;
    for (int bag_limit : max_weight) {
        while (idx < N && jewels[idx].weight <= bag_limit) {
            pq.push(jewels[idx].cost);
            idx++;
        };
        if (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
    }
    cout << ans;

    return 0;
}