#include <bits/stdc++.h>

using namespace std;
constexpr int dx[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };
constexpr int dy[8] = { 2, 1, -1, -2, -2, -1, 1, 2 };

int N;

int bfs(vector<vector<int>>& board, int x, int y, int goalX, int goalY, int l)
{
    board[y][x] = 0;
    queue<pair<int, int>> q;
    q.emplace(x,y);

    while (!q.empty())
    {
        auto [cur_x, cur_y] = q.front(); q.pop();
        for (int dir = 0; dir < 8; dir++)
        {
            int nx = cur_x + dx[dir], ny = cur_y + dy[dir];
            if (nx >= 0 && nx < l && ny >= 0 && ny < l && board[ny][nx] == -1)
            {
                board[ny][nx] = board[cur_y][cur_x] + 1;
                q.emplace(nx, ny);
                if (nx == cur_x && ny == cur_y) return board[ny][nx];
            }
        }
    }
    return board[goalY][goalX];
}


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N;

    while (N--)
    {
        int l; cin >> l;
        vector<vector<int>> board(l,vector<int>(l,-1));
        int nowx, nowy; cin >> nowx >> nowy;
        int goalX, goalY; cin >> goalX >> goalY;
        cout << bfs(board, nowx, nowy, goalX, goalY, l) << "\n";
    }

    return 0;
}