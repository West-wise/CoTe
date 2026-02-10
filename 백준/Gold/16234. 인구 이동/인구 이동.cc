#include <bits/stdc++.h>

using namespace std;
const int dx[4] = {0, 0, -1, 1}; // x: 가로(N)
const int dy[4] = {-1, 1, 0, 0}; // y: 세로(M)

int N,L,R;

bool bfs(vector<vector<int>>& country, vector<vector<bool>>& visited, int x, int y)
{
    queue<pair<int,int>> q;
    vector<pair<int,int>> arr;

    visited[y][x] = true;
    q.emplace(x,y);
    arr.emplace_back(x,y);

    int population = country[y][x];

    while (!q.empty())
    {
        auto [cur_X, cur_Y] = q.front(); q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = cur_X + dx[i], ny = cur_Y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx])
            {
                int diff = abs(country[cur_Y][cur_X] - country[ny][nx]);
                if (diff >= L && diff <= R)
                {
                    q.emplace(nx, ny);
                    visited[ny][nx] = true;
                    population += country[ny][nx];
                    arr.emplace_back(nx, ny);
                }
            }
        }
    }
    if (arr.size() >= 2)
    {
        for (auto [a,b] : arr)
        {
            country[b][a] = population / (int)arr.size();
        }
        return true;
    }
    return false;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> L >> R;
    vector<vector<int>> country(N, vector<int>(N, 0));
    int ans = 0;

    for (int i = 0; i<N; i++)
    {
        for (int k = 0; k < N; k++)
        {
            cin >> country[i][k];
        }
    }

    while (true)
    {
        vector<vector<bool>> visited(N, vector<bool>(N, false));
        bool moved = false;

        for (int i = 0; i<N; i++)
        {
            for (int k = 0; k < N; k++)
            {
                if (visited[i][k]) continue;
                if (bfs(country, visited, k, i)){
                    moved = true;
                }
            }
        }
        if (!moved) break;
        ans++;
    }
    cout << ans;
    return 0;
}