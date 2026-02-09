#include <bits/stdc++.h>

using namespace std;
const int dx[4] = {0, 0, -1, 1}; // x: 가로(N)
const int dy[4] = {-1, 1, 0, 0}; // y: 세로(M)

int M,N,K;
int dfs(vector<vector<bool>>& board, int x, int y)
{
    board[y][x] = true;
    int cnt = 1;
    for (int d = 0; d < 4; d++)
    {
        int nx = x + dx[d], ny = y + dy[d];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && !board[ny][nx])
        {
            cnt += dfs(board, nx, ny);
        }
    }
    return cnt;
}
void pre_build(vector<vector<bool>>& board, pair<int, int>& left, pair<int, int>& right)
{
    for (int i = left.second; i < right.second; i++)
    {
        for (int k = left.first; k < right.first; k++)
        {
            if (i >= 0 && i < M && k >= 0 && k < N)
            {
                board[i][k] = true;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> M >> N >> K;
    vector<vector<bool>> board(M, vector<bool>(N, false));
    vector<int> extend; extend.reserve(K);
    for (int i = 0; i < K; i++)
    {
        pair<int, int> left, right;
        cin >> left.first >> left.second >> right.first >> right.second;
        pre_build(board, left, right);
    }
    for (int i = 0; i<M; i++)
    {
        for (int k = 0; k<N; k++)
        {
            if (!board[i][k]){
                extend.push_back(dfs(board, k,i));
            }
        }
    }
    sort(extend.begin(), extend.end());
    cout << extend.size() << "\n";
    for (int val : extend) cout << val << " ";
    return 0;
}