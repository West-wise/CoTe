#include <string>
#include <algorithm>
#include <bitset>
using namespace std;
int solution(int n) {
    int answer = n+1;
    bitset<20> nb(n);
    string ns = nb.to_string();
    int origin_one_cnt = count(ns.begin(), ns.end(), '1');

    while (true)
    {
        bitset<20> new_nb(answer);
        string ns2 = new_nb.to_string();
        if (origin_one_cnt == count(ns2.begin(), ns2.end(), '1'))
        {
            return answer;
        }
        answer++;
    }
    return 0;
}