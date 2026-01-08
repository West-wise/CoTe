#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

using ll = long long;
using pi = pair<int, int>;

class Edge
{
public:
    int from;
    int to;
    int weight;
    bool operator<(const Edge& e) const {return weight < e.weight;}
};

struct Kruskal
{
    vector<int> parent;
    Kruskal(int n) : parent(n)
    {
        for (int i = 1; i<=n; i++) parent[i] = i;
    }

    int find(int i)
    {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    void _union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootB] = rootA;
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N,M;
    cin >> N >> M;
    vector<Edge> edges(M);
    for (int i = 0; i < M; i++)
    {
        cin >> edges[i].from >> edges[i].to >> edges[i].weight;
    }
    sort(edges.begin(), edges.end());

    Kruskal mst(N);
    ll total_cost = 0;
    int edge_cnt = 0;

    // N-2개의 간선만 연결한다면 마을이 2개로 나뉨
    for (int i = 0; i<M; i++)
    {
        if (edge_cnt == N-2) break;
        if (mst.find(edges[i].from) != mst.find(edges[i].to))
        {
            mst._union(edges[i].from, edges[i].to);
            total_cost += edges[i].weight;
            edge_cnt++;
        }
    }

    cout << total_cost;


    return 0;
}