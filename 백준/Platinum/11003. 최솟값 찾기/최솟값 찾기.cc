#include <iostream>
#include <sstream>
#include <vector>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, win;
    cin >> n >> win;
    cin.ignore();
    string line;
    getline(cin, line);
    istringstream iss(line);
    vector<int> arr(n,0);
    for (int i = 0; i<n; i++){
        iss >> arr[i];
    }
    deque<int> dq ;
    vector<int> answer;

    for (int i = 0; i<n; i++) {
        if (!dq.empty() && dq.front() <= i - win) {
            dq.pop_front();
        }
        while (!dq.empty() && arr[dq.back()] > arr[i]) {
            dq.pop_back();
        }
        dq.push_back(i);
        answer.push_back(arr[dq.front()]);
    }
    ostringstream sb;
    for (int val : answer) {
        sb << val << " ";
    }
    cout << sb.str();
}