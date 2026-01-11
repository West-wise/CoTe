#include <iostream>
#include <vector>
#include <iomanip>
#include <sstream>
using namespace std;

bool isPromising(const vector<string>& map, int x, int y, int tmp)
{
    char c = tmp + '1';
    // 1. 같은 행 확인
    for (int i = 0; i < 9; i++) if (map[y][i] == c) return false;

    // 2. 같은 열 확인
    for (int i = 0; i< 9; i++) if (map[i][x] == c) return false;

    // 3. 3*3 확인
    int areaY = (y/3) * 3;
    int areaX = (x/3) * 3;
    for (int i = areaY; i<areaY + 3; i ++)
    {
        for (int k = areaX; k<areaX + 3; k++)
        {
            if (map[i][k] == c) return false;
        }
    }
    return true;
}

bool solve(vector<string>& map,int x, int y)
{
    if (x == 9) return solve(map, 0, y+1);
    if (y == 9) return true;

    if (map[y][x] == '0')
    {
        for (int i = 0; i<9; i++)
        {
            if (isPromising(map, x,y, i))
            {
                map[y][x] = i + '1';
                if (solve(map, x+1,y)) return true;
                map[y][x] = '0';
            }
        }
    } else
    {
        return solve(map, x+1, y);
    }
    return false;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    vector<string> map(9);
    for (int i = 0; i<9; i++)
    {
        cin >> map[i];
    }
    solve(map, 0,0);
    for (const string&tmp : map)
    {
        cout << tmp << '\n';
    }

    return 0;
}