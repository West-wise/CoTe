#include <algorithm>
#include <iostream>
#include <sstream>
#include <vector>
#include <queue>
#include <unordered_map>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n,m;
    cin >> n >> m;
    int parent[n+1] = {0};
    unordered_map<int,vector<int>> umap;
    for (int i =0; i<m; i++) {
        int from, to;
        cin >> from >> to;
        umap[from].push_back(to);
        parent[to]++;
    }

    queue<int> queue;
    for (int i = 1; i<=n; i++) {
        if (parent[i] == 0) queue.push(i);
    }
    vector<int> answer;

    while (!queue.empty()) {
        int current = queue.front();
        queue.pop();
        answer.push_back(current);
        for (int val : umap[current]) {
            parent[val]--;
            if (parent[val] == 0 ) queue.push(val);
        }
    }
    for (int val : answer) {
        cout << val << " ";
    }
}