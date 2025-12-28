#include <iostream>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    int name_len = name.length();
    // 상하 최적값
    for (const char& c : name)
    {
        if (c == 'A') continue;
        answer += min(c - 'A', 'Z' - c + 1);
    }
    // 좌우 최적값
    int move = name_len-1;
    for (int i = 0; i < name_len; i++)
    {
        int next = i+1;
        while (next < name_len && name[next] == 'A') next++;
        move = min(move, (i+name_len - next + min(i, name_len - next)));
    }
    answer += move;
    return answer;
}