#include <bits/stdc++.h>

using namespace std;
using ll = long long;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N,M;
    cin >> N >> M;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    vector<int> degree(N+1);
    vector<vector<int>> map(N+1);
    for (int i = 1; i<=M; i++)
    {
        string line;
        getline(cin, line);
        stringstream ss(line);
        int num; ss >> num;
        vector<int> order(num);
        for (int k = 0; k<num; k++)
        {
            ss >> order[k];
        }
        for (int j= 0; j<num-1; j++)
        {
            int u = order[j], v = order[j+1];
            map[u].push_back(v);
            degree[v]++; // 진입차수 증가
        }
    }

    queue<int> q;
    vector<int> ans; ans.reserve(N);
    int cnt = 0;
    for (int i = 1; i<=N; i++)
    {
        if (degree[i] == 0) q.push(i);
    }
    if (q.empty())
    {
        cout << 0;
        return 0;
    }
    while (!q.empty())
    {
        int cur = q.front(); q.pop();
        cnt++;
        ans.push_back(cur);
        for (int next : map[cur])
        {
            if (--degree[next] == 0) q.push(next);
        }
    }
    if (cnt != N) cout << 0;
    else
    {
        for (int val : ans) cout << val << "\n";
    }

    return 0;
}