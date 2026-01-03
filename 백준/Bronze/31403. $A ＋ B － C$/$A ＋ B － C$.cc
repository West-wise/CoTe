#include <iostream>
#include <string>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int a,b,c;
    string cat;
    cin >> a >> b >> c;
    cout << a+b-c << '\n';
    cat = to_string(a) + to_string(b);
    cout << stoi(cat)-c << '\n';
    return 0;
}