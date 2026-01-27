#include <bits/stdc++.h>
using namespace std;
using ll = long long;

bool isPromising(const vector<string>& map, int x, int y, int test)
{
    char c = test + '1'; // int값을 char값으로 변경
    // 행 확인
    for (int i = 0; i<9; i++) if (map[y][i] == c) return false;
    // 열 확인
    for (int i = 0; i<9; i++) if (map[i][x] == c) return false;
    // 3*3 확인, (1~3),(4~6),(7~9) 어떤 칸에 속하는지 정하는게 관건
    int areaX = (x/3) * 3; // 보드를 총 가로세로 3개씩 총 9개로 나눔
    int areaY = (y/3) * 3;
    for (int i = areaY; i<areaY + 3; i++) // 각 칸의 +3 범위 내에서 찾음
    {
        for (int k = areaX; k<areaX+3; k++)
        {
            if (map[i][k] == c) return false;
        }
    }
    return true;
}

bool solve(vector<string>& board, int x, int y)
{
    if (x == 9) return solve(board, 0, y+1); // 행 끝까지 갔으면 다음열로 넘어감
    if (y == 9) return true; // 모두 탐색 완료

    if (board[y][x] == '0') // 0일경우 탐색을 해야함
    {
        for (int i = 0; i<9; i++) // 이제 어떤 값이 유망한지 선택해야하기때문에 1~9까지 순회
        {
            if (isPromising(board, x,y,i)) // 만약 유망한 값이면 업데이트!
            {
                board[y][x] = i+'1';
                if (solve(board, x+1, y)) return true; // 다시 재귀적으로 탐색해서 값이 유망한지 판단
                board[y][x] = '0'; // 여기까지 왓다는 것은 유망하지 않다는 뜻이기 때문에 0으로 원복
            }
        }
    }else
    {
        return solve(board, x+1,y);
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    vector<string> board(9);
    for (int i = 0; i<9; i++) cin >> board[i];
    solve(board, 0,0);
    for (const string& line : board)
    {
        cout << line << '\n';
    }
    return 0;
}