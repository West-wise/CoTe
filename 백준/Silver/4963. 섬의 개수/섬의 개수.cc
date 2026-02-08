#include <bits/stdc++.h>

using namespace std;
constexpr int dx[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
constexpr int dy[8] = {0, 0, -1, 1, -1, 1, -1, 1};

int N;
int w;
int h;
void dfs(const vector<vector<int>>& board, vector<vector<bool>>& visited, int x, int y)
{
    visited[y][x] = true;
    for (int d = 0; d < 8; d++)
    {
        int nx = x + dx[d], ny = y + dy[d];
        if (nx >= 0 && nx < w && ny >= 0 && ny < h && !visited[ny][nx] && board[ny][nx] == 1)
        {
            dfs(board, visited, nx, ny);
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    while (true)
    {
        int ans = 0; cin >> w >> h;
        if (w == 0 && h == 0) break;
        vector<vector<int>> board(h, vector<int>(w, 0));
        vector<vector<bool>> visited(h, vector<bool>(w, false));
        for (int i = 0; i < h; i++)
        {
            for (int k = 0; k < w; k++)
            {
                cin >> board[i][k];
            }
        }
        for (int i = 0; i<h; i++)
        {
            for (int k = 0; k<w; k++)
            {
                if (board[i][k] == 1 && !visited[i][k])
                {
                    dfs(board, visited, k, i);
                    ans++;
                }
            }
        }
        cout << ans << "\n";
    }
    return 0;
}