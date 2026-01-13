#include <iostream>
#include <vector>
using namespace std;
struct Cycle
{
    vector<int> dots;
    int cnt;
    bool flag;
    Cycle(int N) : dots(N), cnt(0), flag(false)
    {
        for (int i = 0; i<N; i++)  dots[i] = i;
    }

    int c_find(int a)
    {
        if (dots.at(a) == a) return a;
        return dots.at(a) = c_find(dots.at(a));
    }
    void c_union(int a, int b)
    {
        int rootA = c_find(a);
        int rootB = c_find(b);
        cnt++;
        if (rootA != rootB) dots[rootB] = rootA;
        else flag = true; // 사이클 존재
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N, M;
    cin >> N >> M;
    Cycle cycle(N);
    for (int i = 0; i<M; i++)
    {
        int a, b;
        cin >> a >> b;
        cycle.c_union(a,b);
        if (cycle.flag) break;
    }
    cout << (!cycle.flag ? 0 : cycle.cnt);
    return 0;
}