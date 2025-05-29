#include <algorithm>
#include <iostream>
#include <sstream>
#include <vector>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, m;
    cin >> n >> m;
    vector<int> arr(n,0);
    for (int i = 0; i<n; i++) cin >> arr[i];

    int left = 0;
    int right = n-1;
    int answer = 0;
    sort(arr.begin(), arr.end());
    while (left < right) {
        int tmp = arr[left] + arr[right];
        if (tmp == m) {
            answer++;
            left++;
            right--;
        } else if (tmp < m) {
            left++;
        } else {
            right--;
        }
    }
    cout << answer;
}