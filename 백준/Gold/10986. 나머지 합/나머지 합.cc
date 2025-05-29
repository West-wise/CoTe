#include <iostream>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, m;
    cin >> n >> m;
    cin.ignore();
    int array[n] = {0};
    string line;
    getline(cin, line);
    istringstream iss(line);
    for (int i =0; i<n; i++) {
        iss >> array[i];
    }
    long answer = 0;
    long S[n] = {0};
    int C[m] = {0} ;
    S[0] = array[0];
    for (int i = 1; i<n; i++) {
        S[i] = S[i-1] + array[i];
    }
    for (int i = 0; i<n; i++) {
        int remain = (int) (S[i] % m);
        if (remain == 0) answer++;
        C[remain]++;
    }
    for (int i = 0; i<m; i++) {
        if (C[i]>1) answer += ((long) C[i] * (C[i]-1) / 2);
    }
    cout << answer;
    return 0;
}