#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

vector<vector<char>> board;
vector<bool> visited(20, false);

int R, C;
int answer = 0;


void DFS(int x, int y, int depth){
    answer = max(answer, depth);
    vector<pair<int, int>> direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    visited[board[x][y] - 'A'] = true;

    for (auto dir : direction){
        int nx = x + dir.first;
        int ny = y + dir.second;
        if (nx >= 0 && nx < R && ny >= 0 && ny < C){
            if (!visited[board[nx][ny] - 'A']){
                DFS(nx, ny, depth + 1);
                visited[board[nx][ny] - 'A'] = false;
            }
        }
    }

}


int main(){
    cin >> R >> C;
    board.resize(R, vector<char>(C, 0));
    for(int i=0; i<R; i++){
        for(int k=0; k<C; k++){
            cin >> board[i][k];
        }
    }

    DFS(0, 0, 1);
    cout << answer << endl;
    return 0;
}