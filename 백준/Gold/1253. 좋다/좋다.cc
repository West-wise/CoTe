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

    int n;
    cin >> n;
    vector<int> arr(n,0);
    for (int i = 0; i<n; i++) cin >> arr[i];
    sort(arr.begin(), arr.end());
    long answer = 0;
    for (int idx = 0; idx<n; idx++) {
        int left = 0;
        int right = n-1;
        int target = arr[idx];
        while (left < right) {
            int tmp = arr[left] + arr[right];
            if (tmp == target) {
                if (left != idx && right != idx){
                    answer++;
                    break;
                } else if (left == idx) {
                    left++;
                } else {
                    right--;
                }
            } else if (tmp > target) {
                right--;
            } else {
                left++;
            }
        }
    }
    cout << answer;
}