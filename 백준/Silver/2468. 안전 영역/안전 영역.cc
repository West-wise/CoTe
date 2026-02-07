#include <bits/stdc++.h>
#include <iostream>
#include <unordered_set>

using namespace std;
constexpr int dx[4] = {-1, 1, 0, 0};
constexpr int dy[4] = {0, 0, -1, 1};
int N;
int dfs(const vector<vector<int>>& area, vector<vector<bool>>& visited, int x, int y, int limit)
{
    visited[y][x] = true;
    int safe_size = 1;
    for (int dir = 0; dir < 4; dir++)
    {
        int nx = x + dx[dir], ny = y + dy[dir];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N && area[ny][nx] > limit && !visited[ny][nx])
        {
            safe_size += dfs(area, visited, nx, ny, limit);
        }
    }
    return safe_size;
}


int main(){
    cin >> N;
    vector<vector<int>> area(vector<vector<int>>(N, vector<int>(N, 0)));
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int k = 0; k < N; k++)
        {
            cin >> area[i][k];
        }
    }

    for (int limit = 0; limit <= 100; limit++)
    {
        vector<vector<bool>> visited(N, vector<bool>(N, false));
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (area[i][k] > limit && !visited[i][k]) {
                    dfs(area, visited, k, i, limit);
                    tmp++;
                }
            }
        }
        ans = max(ans, tmp);
    }
    cout << ans << "\n";
    return 0;
}