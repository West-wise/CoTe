#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int A, ans = 0;
    cin >> A;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    vector<int> arr(A,0), tail;
    tail.reserve(A);
    string line;
    getline(cin, line);
    stringstream ss(line);
    for (int i = 0; i < A; i++) ss >> arr[i];
    tail.push_back(arr[0]);

    for (int i = 0; i<A; i++)
    {
        if (tail.back() < arr[i]) tail.push_back(arr[i]);
        else
        {
            auto it = lower_bound(tail.begin(), tail.end(), arr[i]);
            *it = arr[i];
        }
    }
    cout << tail.size();
    return 0;
}