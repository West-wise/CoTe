#include <iostream>
#include <limits>
#include <sstream>
#include <vector>
#include <regex>
using namespace std;

const int INF = numeric_limits<int>::max();

class Edge {
public:
    int from, to, weight;
    Edge(int u, int v, int w) : from(u), to(v), weight(w){}
};

static int N,M;
static vector<Edge> graph;
static vector<long long> dist;

bool bellman_ford() {
    dist.assign(N+1,INF);
    dist[1] = 0;

    for (int i = 1; i<N; i++) {
        for (const Edge& edge : graph) {
            int start = edge.from;
            int end = edge.to;
            int cost = edge.weight;

            if (dist[start] != INF && dist[end] > dist[start] + cost) {
                dist[end] = dist[start] + cost;
            }
        }
    }
    // 음수 사이클 검사
    for (const Edge& edge : graph) {
        if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) return false;
    }
    return true;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N >> M;

    for (int i = 0; i<M; i++) {
        int start, end, cost;
        cin >> start >> end >> cost;
        graph.emplace_back(start, end, cost);
    }

    bool flag = bellman_ford();
    if (!flag) {
        cout << -1 << '\n';
    } else {
        for (int i = 2; i <= N; i++) {
            cout << ((dist[i] == INF) ? -1 : dist[i]) << '\n';
        }
    }
    return 0;
}