#include <algorithm>
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

using ll = long long;

struct TreeNode
{
    vector<vector<int>> adj;
    vector<int> parent;
    vector<int> dp;
    TreeNode(int N) : adj(N+1), parent(N+1,-1), dp(N+1,0){}

    void addEdge(int u, int v)
    {
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    void build(int root)
    {
        dfs(root, -1);
    }
private:
    int dfs(int cur, int par)
    {
        parent[cur] = par;
        dp[cur] = 1;
        for (int next : adj[cur])
        {
            if (next == par) continue;
            dp[cur] += dfs(next, cur);
        }
        return dp[cur];
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N,R,Q;
    cin>>N>>R>>Q;
    TreeNode tree(N);
    for (int i = 0; i<N-1; i++)
    {
        int node1, node2;
        cin >> node1 >> node2;
        tree.addEdge(node1, node2);
    }
    tree.build(R);

    for (int i = 0; i<Q; i++)
    {
        int start;
        cin >> start;
        cout << tree.dp[start] << '\n';
    }


    return 0;
}