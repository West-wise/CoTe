#include <iostream>
#include <vector>
#include <queue>

using namespace std;


bool isPromising(const vector<string>& map, int x, int y, int tmp) {
    // 1. 같은 행 검사
    char tmp_char = tmp+'1';
    for (int i = 0; i<9; i++) if (map[y][i] == tmp_char) return false;

    // 2. 같은 열 검사
    for (int i = 0; i<9; i++) if (map[i][x] == tmp_char) return false;

    // 3. 3*3 검사
    int areaX = x/3*3;
    int areaY = y/3*3;
    for (int i = areaY; i<areaY+3; i++) {
        for (int k = areaX; k<areaX+3; k++) {
            if (map[i][k] == tmp_char) return false;
        }
    }
    return true;
}

bool solve(vector<string>& map,int x, int y) {
    if (x == 9) return solve(map, 0, y+1);
    if (y == 9) return true;

    if (map[y][x] == '0') {
        for (int i = 0; i<9; i++) {
            if (isPromising(map, x,y,i)) {
                map[y][x] = i + '1';
                if (solve(map,x+1,y)) {
                    return true;
                }
            }
            map[y][x] = 0+'0';
        }
    } else {
        return solve(map, x+1, y);
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    vector<string> map(9);
    for (int i = 0; i<9; i++) {
        cin >> map[i];
    }

    solve(map, 0,0);

    for (int i = 0; i<9; i++) {
        cout << map[i] << '\n';
    }
    return 0;
}