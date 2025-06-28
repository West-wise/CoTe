#include <iostream>
#include <sstream>
#include <vector>
#include <queue>
#include <regex>
using namespace std;



class Path {
public:
    int node;
    int cost;
    Path(int node, int cost) : node(node), cost(cost) {};
    bool operator<(const Path& path) const {
        return this->cost > path.cost;
    }
};

struct Edge {
    int node;
    int cost;
    Edge(int node, int cost) : node(node), cost(cost){}
};
static int N,M,K;
static vector<vector<Edge>> graph;


void Dijkstra(vector<priority_queue<int>> &dist) {
    priority_queue<Path> pq;
    pq.emplace(1,0);
    dist[1].push(0);

    while (!pq.empty()) {
        Path cp = pq.top(); pq.pop();
        int cc = cp.cost;
        int cn = cp.node;

        for (const auto& [next_node, edge_cost] : graph[cn]) {
            int next_cost = edge_cost + cc;
            if (dist[next_node].size() < K) {
                dist[next_node].push(next_cost);
                pq.emplace(next_node, next_cost);
            } else if (dist[next_node].top() > next_cost) {
                dist[next_node].pop();
                dist[next_node].push(next_cost);
                pq.emplace(next_node, next_cost);
            }
        }
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N >> M >> K;
    graph.resize(N+1);
    for (int i = 0; i<M; i++) {
        int a,b,c;
        cin >> a >> b >> c;
        graph[a].emplace_back(b,c);
    }

    vector<priority_queue<int>> dist(N+1);

    Dijkstra(dist);

    for (int i = 1; i<=N; i++) {
        if (dist[i].size() < K) {
            cout << -1 << "\n";
        } else {
            cout << dist[i].top() << "\n";
        }
    }
    return 0;
}



