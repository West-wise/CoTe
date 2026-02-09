#include <bits/stdc++.h>
using namespace std;
int M,N;
int bfs(vector<vector<int>>& family, int x, int y)
{
    vector<int> dist(N+1, -1);
    queue<int> q;
    q.push(x);
    dist[x] = 0;
    while (!q.empty())
    {
        int cur = q.front(); q.pop();
        if (cur == y) return dist[cur];
        for (int next : family[cur])
        {
            if (dist[next] == -1)
            {
                q.push(next);
                dist[next] = dist[cur] + 1;
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N;
    int x,y; cin >> x >> y;
    cin >> M;
    vector<vector<int>> family(N+1);
    for (int i = 0; i<M; i++)
    {
        int a,b; cin >> a >> b;
        family[a].push_back(b);
        family[b].push_back(a);
    }
    cout << bfs(family, x, y) << "\n";
    return 0;
}