#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int N,M;

const int dx[4] = {1,-1, 0, 0};
const int dy[4] = {0, 0, 1, -1};

int dfs(const vector<vector<int>>& board, vector<vector<bool>>& visited, int x, int y) {
    visited[y][x] = true;
    int picture_size = 1;
    for (int dir = 0; dir < 4;  dir++) {
        int nx = x + dx[dir], ny = y + dy[dir];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx] && board[ny][nx] == 1) {
            picture_size += dfs(board, visited, nx, ny);
        }
    }
    return picture_size;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    cin >> N >>M;
    vector<vector<int>> board(N, vector<int>(M, 0));
    for (int i = 0; i<N; i++) {
        for (int k = 0; k < M; k++) {
            cin >> board[i][k];
        }
    }

    int cnt = 0, max_size = 0;
    vector<vector<bool>> visited(N, vector<bool>(M, false));
    for (int i = 0; i < N; i++) {
        for (int k = 0; k < M; k++) {
            if (board[i][k] == 1 && !visited[i][k]) {
                max_size = max(max_size, dfs(board, visited, k, i));
                cnt++;
            }
        }
    }
    cout << cnt << "\n" << max_size;
    return 0;
}