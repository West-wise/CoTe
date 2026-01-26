#include <bits/stdc++.h>
using namespace std;
using ll = long long;
typedef pair<ll, ll> Point;
int ccw(Point p1, Point p2, Point p3)
{
    ll res = (p2.first - p1.first) * (p3.second - p1.second) - (p2.second - p1.second) * (p3.first - p1.first);
    if (res > 0) return 1;  // 반시계
    if (res < 0) return -1; // 시계
    return 0;               // 일직선
}

bool isCross(Point p1, Point p2, Point p3, Point p4)
{
    int abc = ccw(p1, p2, p3) * ccw(p1,p2,p4);
    int cda = ccw(p3, p4, p1) * ccw(p3,p4,p2);
    if (abc == 0 && cda == 0) // 일직선에 있을 경우
    {
        if (p1 > p2) swap(p1,p2); // 좌표들을 크기 순으로 정렬한다
        if (p3 > p4) swap(p3,p4);
        return p1 <= p4 && p3 <= p2;
    }
    return abc <= 0 && cda <= 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    Point p1, p2, p3, p4;
    cin >> p1.first >> p1.second >> p2.first >> p2.second;
    cin >> p3.first >> p3.second >> p4.first >> p4.second;
    cout << (isCross(p1,p2,p3,p4) ? 1 : 0);
    return 0;
}