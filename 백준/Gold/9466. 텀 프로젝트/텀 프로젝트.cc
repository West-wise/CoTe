#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int ans = 0;

void dfs(const vector<int>& graph, vector<bool>& visited, vector<bool>& finished, int cur)
{
    visited[cur] = true;
    int next = graph[cur];
    if (!visited[next]) dfs(graph, visited, finished, next);
    else if (!finished[next])
    {
        for (int i = next; i!=cur; i = graph[i]) ans++;
        ans++;
    }
    finished[cur] = true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int T; cin >> T;
    int N;
    while(T--)
    {
        ans = 0;
        cin >> N;
        vector<int> graph(N+1);
        vector<bool> visited(N+1, false);
        vector<bool> finished(N+1, false);
        for(int i = 1; i <=N; i++) cin >> graph[i];
        for (int i = 1; i<=N; i++)
        {
            if (visited[i]) continue;
            dfs(graph, visited, finished,i);
        }
        cout << N-ans << "\n";
    }
    return 0;
}