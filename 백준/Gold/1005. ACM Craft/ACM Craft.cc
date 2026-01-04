#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T,N,K,W;
    cin >> T;
    while (T--)
    {
        cin >> N >> K;
        vector<int> buildings(N+1);
        vector<vector<int>> graph(N+1); // number : [in, cost]
        vector<int> degrees(N+1,0); // 진입 차수를 의미
        vector<int> dp(N+1,0); // dp계산
        queue<int> q;
        for (int i = 1; i <=N; i++)
        {
            cin >> buildings[i];
        }
        for (int i = 0; i<K; i++)
        {
            int first, next; // first -> next
            cin >> first >> next;
            graph[first].emplace_back(next);
            degrees[next]++;
        }
        cin >> W;

        for (int i = 1; i<=N; i++)
        {
            if (degrees[i] == 0)
            {
                q.push(i);
                dp[i] = buildings[i];
            }
        }

        while (!q.empty())
        {
            int cur = q.front(); q.pop();
            for (int next : graph[cur])
            {
                dp[next] = max(dp[next], dp[cur] + buildings[next]);
                if (--degrees[next] == 0) q.push(next);
            }
        }
        cout << dp[W] << endl;
    }
    return 0;
}