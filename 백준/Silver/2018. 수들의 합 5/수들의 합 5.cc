#include <iostream>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    int answer = 0;
    for (int i = 1; i<=n; i++) {
        int tmp = n - (i * (i-1)) /2;
        if (tmp <= 0) break;
        if (tmp % i == 0) answer++;
    }
    cout << answer;
}