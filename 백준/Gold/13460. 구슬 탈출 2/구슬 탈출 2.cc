#include <bits/stdc++.h>

using namespace std;
using pi = pair<int, int>;

const int dx[4] = {0, 0, -1, 1}; // x: 가로(N)
const int dy[4] = {-1, 1, 0, 0}; // y: 세로(M)

int N,M;

struct State
{
    int red_x, red_y;
    int blue_x, blue_y;
    int cnt = 0;
};

pair<int, int> roll(int x, int y, int dir, const vector<vector<char>> &board)
{
    while (true)
    {
        int nx = x + dx[dir], ny = y + dy[dir];
        if (nx < 0 || nx >= M || ny < 0 || ny >= N) break;
        if (board[ny][nx] == '#') break;
        x = nx, y = ny;
        if (board[ny][nx] == 'O') break;
    }
    return {x, y};
}

int bfs(const vector<vector<char>>& board, pi red, pi blue)
{
    int rx = red.first, ry = red.second;
    int bx = blue.first, by = blue.second;
    queue<State> q;
    vector<vector<vector<vector<bool>>>> visited(N,
        vector<vector<vector<bool>>>(M,
        vector<vector<bool>>(N,
        vector<bool>(M, false))));
    visited[ry][rx][by][bx] = true;
    q.push({rx, ry, bx, by, 0});

    while (!q.empty())
    {
        auto [crx, cry, cbx, cby, ccnt] = q.front(); q.pop();
        if (ccnt >= 10) continue;
        for (int dir = 0; dir < 4; dir++)
        {
            auto [nrx, nry] = roll(crx, cry, dir, board);
            auto [nbx, nby] = roll(cbx, cby, dir, board);
            if (board[nby][nbx] == 'O') continue;
            if (board[nry][nrx] == 'O') return ccnt+1;
            if (nrx == nbx && nry == nby) {
                int red_dist = abs(nrx - crx) + abs(nry - cry);
                int blue_dist = abs(nbx - cbx) + abs(nby - cby);
                if (red_dist > blue_dist) {
                    nrx -= dx[dir];
                    nry -= dy[dir];
                } else {
                    nbx -= dx[dir];
                    nby -= dy[dir];
                }
            }
            if (!visited[nry][nrx][nby][nbx]) {
                visited[nry][nrx][nby][nbx] = true;
                q.push({nrx, nry, nbx, nby, ccnt + 1});
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    vector<vector<char>> board(N, vector<char>(M));

    for (int i = 0; i < N; i++)
    {
        for (int k = 0; k < M; k++)
        {
            cin >> board[i][k];
        }
    }
    pair<int, int> r,b,g;
    for (int i = 0; i < N; i++)
    {
        for (int k = 0; k < M; k++)
        {
            if (board[i][k] == 'R') r = { k,i };
            if (board[i][k] == 'B') b = { k,i };
        }
    }
    cout << bfs(board, r, b);
    return 0;
}