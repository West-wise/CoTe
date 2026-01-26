#include <bits/stdc++.h>

using namespace std;
using ll = long long;

struct Point
{
    ll x,y;

    bool operator <= (const Point &p) const
    {
        if (x!=p.x) return x < p.x;
        return y <= p.y;
    }
    bool operator>(const Point& p) const {
        if (x != p.x) return x > p.x;
        return y > p.y;
    }
};

int ccw(Point p1, Point p2, Point p3)
{
    ll res = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    if (res > 0) return 1;  // 반시계
    if (res < 0) return -1; // 시계
    return 0;               // 일직선
}

bool isCross(Point p1, Point p2, Point p3, Point p4)
{
    int abc = ccw(p1, p2, p3);
    int abd = ccw(p1, p2, p4);
    int cda = ccw(p3, p4, p1);
    int cdb = ccw(p3, p4, p2);

    if (abc * abd == 0 && cda * cdb == 0)
    {
        if (p1 > p2)swap(p1,p2);
        if (p3 > p4) swap(p3,p4);
        return p1 <= p4 && p3 <= p2;
    }

    return (abc * abd) <= 0 && (cda * cdb) <= 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    Point p1, p2, p3, p4;
    cin >> p1.x >> p1.y >> p2.x >> p2.y;
    cin >> p3.x >> p3.y >> p4.x >> p4.y;
    cout << (isCross(p1,p2,p3,p4) ? 1 : 0);
    return 0;
}